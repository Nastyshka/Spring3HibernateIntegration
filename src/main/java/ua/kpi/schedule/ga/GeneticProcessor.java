package ua.kpi.schedule.ga;

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

        //Get subjectGene
        Subject[] subjects = (Subject[]) data.getSubjects().toArray();
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


    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;

    }
}