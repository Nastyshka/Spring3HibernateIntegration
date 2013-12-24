package ua.kpi.schedule.ga;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ua.kpi.schedule.dto.DataBundle;
import ua.kpi.schedule.model.Classroom;
import ua.kpi.schedule.model.Subject;
import ua.kpi.schedule.model.Teacher;
import ua.kpi.schedule.model.TimeSlot;
import ua.kpi.schedule.processors.DataManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Me on 24.12.13.
 */
public class GeneticProcessor {

    private static final Logger logger = Logger.getLogger(GeneticProcessor.class);
    @Value ("${chromosomeSize}")
    private Integer chromosomeSize;
    @Value ("${populationSize}")
    private Integer populationSize;
    @Value ("${maxEvolution}")
    private Integer maxEvolution;
    @Value ("${threshold}")
    private Integer threshold;

    @Autowired
    private DataManager dataManager;

    private Classroom [] classrooms;
    private Teacher[] teachers;
    private Subject[] subjects;
    private TimeSlot[] timeSlots;

    /**
     * Setup initial data for geneti algorithm
     */
    public void setupGenes(){
        logger.trace("chromosome_size:" +  chromosomeSize +
                " population_size:" + populationSize +
                " max_evolution:" + maxEvolution +
                " threshold:" + threshold);
        DataBundle data = dataManager.getAllData();

        // Get classGenes data
        classrooms = (Classroom[]) data.getClassrooms().toArray();
        ClassGene.setMax_idClass(classrooms.length);
        for (int i = 0; i < classrooms.length; i++){
            ClassGene.setInputClassSize(classrooms[i].getSize(), i);
            logger.trace("Classroom: idClass=" +
                    classrooms[i].getNumber() + " classSize=" +
                    classrooms[i].getSize());
        }

        //Get subjectGenes (LessonGene)
        subjects = (Subject[]) data.getSubjects().toArray();
        LessonGene.setMax_idLesson(subjects.length);
        for (int i = 0; i < subjects.length; i++){
             logger.trace("Suject " + subjects[i].getNameSubject() +
                            " id SubjectGene: " + i);
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

    public void setChromosomeSize(Integer chromosomeSize) {
        this.chromosomeSize = chromosomeSize;
    }

    public void setPopulationSize(Integer populationSize) {
        this.populationSize = populationSize;
    }

    public void setMaxEvolution(Integer maxEvolution) {
        this.maxEvolution = maxEvolution;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }


}
