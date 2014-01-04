package ua.kpi.schedule.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import ua.kpi.schedule.dao.*;
import ua.kpi.schedule.dto.DataBundle;
import ua.kpi.schedule.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nastyshka
 * Date: 07.12.13
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
public class DataManager {

    @Autowired
    private TimeslotDAO timeslotDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private ClassroomDAO classroomDAO;

    @Value("${daysOfWeek}")
    private List<String> daysOfWeek;

    @Transactional
    public DataBundle getAllData(){
        DataBundle dataBundle = new DataBundle();
        dataBundle.setGroups(groupDAO.getAll());
        dataBundle.setSubjects(subjectDAO.getAll());
        dataBundle.setTeachers(teacherDAO.getAll());
        dataBundle.setClassrooms(classroomDAO.getAll());
        dataBundle.setTimeSlots(timeslotDAO.getAll());
        return dataBundle;
    }

    public Teacher findTeacher(int idTeacher) {
        return teacherDAO.find(idTeacher);
    }

    public Classroom findClassroom(int idClassroom) {
        return classroomDAO.find(idClassroom);
    }

    public Group findGroup(int idGroup) {
        return groupDAO.find(idGroup);
    }

    public Subject findSubject(int idSubject) {
        return subjectDAO.find(idSubject);
    }

    public TeacherDAO getTeacherDAO() {
        return teacherDAO;
    }

    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public SubjectDAO getSubjectDAO() {
        return subjectDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public ClassroomDAO getClassroomDAO() {
        return classroomDAO;
    }

    public void setClassroomDAO(ClassroomDAO classroomDAO) {
        this.classroomDAO = classroomDAO;
    }

    public DataManager() {
    }

    public void saveClassroom(Classroom classroom) {
        classroomDAO.save(classroom);
//        return classroom.getIdClassroom();
    }

    public void saveGroup(Group group) {
        groupDAO.save(group);
    }

    public void saveTeacher(Teacher teacher) {
        teacherDAO.save(teacher);
    }


    public void saveSubject(Subject subject) {
        subjectDAO.save(subject);
    }

    public void saveTimeslot(TimeSlot timeslot) {
        timeslotDAO.save(timeslot);
    }

    public TimeSlot findTimeslot(Integer selectedTimeslot) {
        return timeslotDAO.find(selectedTimeslot);
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<String> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public TimeslotDAO getTimeslotDAO() {
        return timeslotDAO;
    }

    public void setTimeslotDAO(TimeslotDAO timeslotDAO) {
        this.timeslotDAO = timeslotDAO;
    }
}
