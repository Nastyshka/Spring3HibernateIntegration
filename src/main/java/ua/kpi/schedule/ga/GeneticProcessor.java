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

    public void setUpGenes(){
        DataBundle data = dataManager.getAllData();
        //Get ClassGenes (Classroom)
        Classroom[] allClassrooms = (Classroom[]) data.getClassrooms().toArray();
        ClassGene.setMax_idClass(allClassrooms.length);
        for (int i = 0; i < allClassrooms.length; i++){

            ClassGene.setInputClassSize(allClassrooms[i].getSize(), i);
            logger.trace("Classroom number " + allClassrooms[i].getNumber() +
                    "ClassRoomId = " + i + " size " + allClassrooms[i].getSize());
        }

        //Get GroupGenes
        List<Group> allGroups = data.getGroups();
        GroupGene.setMax_idGroup(allGroups.size());
        for (int i = 0; i < allGroups.size(); i++){
            GroupGene.setInputGroupSize(allGroups.get(i).getSize(), i);
            logger.trace("Group number " + allGroups.get(i) +
                    "GroupId = " + i + " size " + allGroups.get(i).getSize());
        }

        //Get subjectGene
        Subject[] subjects = (Subject[]) data.getSubjects().toArray();
        LessonGene.setMax_idLesson(subjects.length);
        for (int i = 0; i < subjects.length; i++){
            logger.trace("Subject " + allGroups.get(i) +
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