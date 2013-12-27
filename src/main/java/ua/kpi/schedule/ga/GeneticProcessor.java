package ua.kpi.schedule.ga;

import org.jgap.Chromosome;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import ua.kpi.schedule.dto.DataBundle;
import ua.kpi.schedule.model.*;
import ua.kpi.schedule.processors.DataManager;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * @author AnastasiyaR
 */

public class GeneticProcessor {

    private final static Logger logger =  Logger.getLogger(GeneticProcessor.class);
    @Autowired
    private DataManager dataManager;
    @Autowired
    private TimeSlotHandler timeSlotHandler;
    @Value("${chromosomeSize}")
    private Integer chromosomeSize;
    @Value("${populationSize")
    private Integer populationSize;
    @Value("${maxEvolution}")
    private  Integer maxEvolution;
    @Value("${threshold}")
    private Integer threshold;

    private Classroom [] classrooms;
    private Teacher[] teachers;
    private Subject[] subjects;
    private TimeSlot[] timeSlots;
    private Group[] groups;

    private Integer max_idGroup;
    private Integer max_idTime;

    public void setUpGenes(){
        DataBundle data = dataManager.getAllData();
        //Get ClassGenes (Classroom)
        classrooms = (Classroom[]) data.getClassrooms().toArray();
        ClassGene.setMax_idClass(classrooms.length);
        for (int i = 0; i < classrooms.length; i++){
            ClassGene.setInputClassSize(classrooms[i].getSize(), i);
            logger.trace("Classroom number " + classrooms[i].getNumber() +
                    "ClassRoomId = " + i + " size " + classrooms[i].getSize());
        }

        //Get GroupGenes
        groups = (Group[]) data.getGroups().toArray();
        GroupGene.setMax_idGroup(groups.length);
        for (int i = 0; i < groups.length; i++){
            GroupGene.setInputGroupSize(groups[i].getSize(), i);
            logger.trace("Group number " + groups[i].getNameGroup() +
                    "GroupId = " + i + " size " + groups.length);
        }

        //GetTimeGenes
        timeSlots = timeSlotHandler.getTimeSlots();
        TimeGene.setMax_idTimeSlot(timeSlots.length);
        for (int i = 0; i < timeSlots.length; i++) {
            System.out.println(timeSlots[i].getIdTimeSlot() + ": idTimeSlotGene=" + i);

        }

        //Get subjectGene
        subjects = (Subject[]) data.getSubjects().toArray();
        LessonGene.setMax_idLesson(subjects.length);
        for (int i = 0; i < subjects.length; i++){
            logger.trace("Subject " + groups[i].getNameGroup() +
                    "SubjectGeneId = " + i);
        }

        // Get teacherGenes data
        teachers = (Teacher[]) data.getTeachers().toArray();
        TeacherGene.setMax_idTeacher(teachers.length);
        for (int i = 0; i < teachers.length; i++){
            Teacher teacher = teachers[i];
            TeacherGene.setAll_avaliableLessons(getAvailableSubjectsForTeacher(teacher), i);
            TeacherGene.setAll_avaliableTimeSlots(getAvailableTimeSlotsForTeacher(teacher), i);
            logger.trace("Teacher " + teacher.getNameUser() + " idTeacherGene " + i +
                    " avaliableLessons=" + getAvailableSubjectsForTeacher(teacher)+
                    " avaliableTimeSlots=" + getAvailableTimeSlotsForTeacher(teacher));
        }
    }

    /**
     * Return gene`s id  of teacher`s available subjects
     * @param teacher
     * @return
     */
    private Integer[] getAvailableSubjectsForTeacher(Teacher teacher){
        List<Integer> availableSubjectsIds = new ArrayList<Integer>();
        for (Subject subject : teacher.getSubjects()){
            int i = 0;
            while (subjects[i] != subject) {
                i++;
            }
            availableSubjectsIds.add(i);
        }
        return (Integer[]) availableSubjectsIds.toArray();
    }

    /**
     * Return gene`s id  of teacher`s available timeslots
     * @param teacher
     * @return
     */
    private Integer[] getAvailableTimeSlotsForTeacher(Teacher teacher){
        List<Integer> availableTimeSlots = new ArrayList<Integer>();
        for (TimeSlot timeSlot : teacher.getAvailableTimeslots()){
            int i = 0;
            while (timeSlots[i] != timeSlot) {
                i++;
            }
            availableTimeSlots.add(i);
        }
        return (Integer[]) availableTimeSlots.toArray();
    }

    public List <Lesson> extractLessonsDataFromChromosome(Chromosome bestChromosome){
        List <Lesson> timetable = new ArrayList<Lesson>();

        // Extracting GroupClassTimeSupergene from a_bestChromosome
        GroupClassTeacherLessonTimeSG[] s =
                new GroupClassTeacherLessonTimeSG[Start.CHROMOSOME_SIZE];
        s[0] = (GroupClassTeacherLessonTimeSG) bestChromosome.getGene(0);
        // Extracting max_idGroup from GroupGene
        GroupGene gg = (GroupGene)s[0].geneAt(Start.GROUP);
        max_idGroup = gg.getMax_idGroup();

        // first - Group, second - Time
        String[][] str = new String[max_idGroup][max_idTime];
        for (int i = 0; i < max_idGroup; i++) {
            for (int j = 0; j < max_idTime; j++) {
                str[i][j] = "-/-/-";
            }
        }

        for (int i = 0; i < Start.CHROMOSOME_SIZE; i++) {
            s[i] = (GroupClassTeacherLessonTimeSG) bestChromosome.getGene(i);




            // Here we are going through all of the id_groups and the id_times
            // and filling str[][] array
            for (int j = 0; j < max_idGroup; j++) {
                Lesson lesson = new Lesson();
                for (int k = 0; k < max_idTime; k++) {
                    if ((Integer) s[i].geneAt(Start.GROUP).getAllele() == j &&
                            (Integer) s[i].geneAt(Start.TIME).getAllele() == k) {
                        str[j][k] =
                                s[i].geneAt(Start.LESSON).getAllele().toString() + "/" +
                                        s[i].geneAt(Start.TEACHER).getAllele().toString() + "/" +
                                        s[i].geneAt(Start.CLASS).getAllele().toString();
                        lesson.setClassroom(classrooms[new Integer(s[i].geneAt(Start.CLASS).getAllele().toString())]);
                        lesson.setTeacher(teachers[new Integer(s[i].geneAt(Start.TEACHER).getAllele().toString())]);
                        lesson.setSubject(subjects[new Integer(s[i].geneAt(Start.LESSON).getAllele().toString())]);
                        lesson.setTimeSlot(timeSlots[new Integer(s[i].geneAt(Start.TIME).getAllele().toString())]);
                        lesson.setGroup(groups[new Integer(s[i].geneAt(Start.GROUP).getAllele().toString())]);
                        timetable.add(lesson);
                    }
                }
            }
        }
        return timetable;
    }
    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;

    }
}