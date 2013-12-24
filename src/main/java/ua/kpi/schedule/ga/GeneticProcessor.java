package ua.kpi.schedule.ga;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import ua.kpi.schedule.dao.ClassroomDAO;
import ua.kpi.schedule.dao.GroupDAO;
import ua.kpi.schedule.dao.SubjectDAO;
import ua.kpi.schedule.dao.TeacherDAO;
import ua.kpi.schedule.dto.DataBundle;
import ua.kpi.schedule.model.Classroom;
import ua.kpi.schedule.model.Group;
import ua.kpi.schedule.model.Subject;
import ua.kpi.schedule.model.Teacher;
import ua.kpi.schedule.processors.DataManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * @author AnastasiyaR
 */

public class GeneticProcessor {

    private final static Logger logger =  Logger.getLogger(GeneticProcessor.class);
    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private ClassroomDAO classroomDAO;

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

    public void setUpGenes(){
        DataBundle dataAll = dataManager.getAllData();
        //Get ClassGenes (Classroom)
        List<Classroom> allClassrooms = dataAll.getClassrooms();
        ClassGene.setMax_idClass(allClassrooms.size());
        for (int i = 0; i < allClassrooms.size(); i++){

            ClassGene.setInputClassSize(allClassrooms.get(i).getSize(), i);
            logger.trace("Classroom number " + allClassrooms.get(i) +
            "ClassRoomId = " + i + " size " + allClassrooms.get(i).getSize());
        }

        //Get GroupGenes
        List<Group> allGroups = dataAll.getGroups();
        GroupGene.setMax_idGroup(allGroups.size());
        for (int i = 0; i < allGroups.size(); i++){
            GroupGene.setInputGroupSize(allGroups.get(i).getSize(), i);
            logger.trace("Group number " + allGroups.get(i) +
                    "GroupId = " + i + " size " + allGroups.get(i).getSize());
        }

        //TODO: review teacher
//        //Get TeacherGenes
//        List<Teacher> allTeachers = dataAll.getTeachers();
//        ClassGene.setMax_idClass(allTeachers.size());
//        for (int i = 0; i < allTeachers.size(); i++){
//
//            TeacherGene.setAll_avaliableLessons();
//            logger.trace("Classroom number " + allClassrooms.get(i) +
//                    "ClassRoomId = " + i + " size " + allClassrooms.get(i).getSize());
//        }

        //Get subjectGene
        Subject[] subjects = (Subject[]) dataAll.getSubjects().toArray();
        LessonGene.setMax_idLesson(subjects.length);
        for (int i = 0; i < subjects.length; i++){
            logger.trace("Subject " + allGroups.get(i) +
                    "SubjectGeneId = " + i);
        }
    }

    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public void setClassroomDAO(ClassroomDAO classroomDAO) {
        this.classroomDAO = classroomDAO;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
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
}
