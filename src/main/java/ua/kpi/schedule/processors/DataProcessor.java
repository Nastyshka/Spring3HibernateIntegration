package ua.kpi.schedule.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ua.kpi.schedule.dao.ClassroomDAO;
import ua.kpi.schedule.dao.GroupDAO;
import ua.kpi.schedule.dao.SubjectDAO;
import ua.kpi.schedule.dao.TeacherDAO;
import ua.kpi.schedule.dto.DataBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Nastyshka
 * Date: 07.12.13
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
public class DataProcessor {
    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private ClassroomDAO classroomDAO;

    public DataBundle getAllData(){
        DataBundle dataBundle = new DataBundle();
        dataBundle.setGroups(groupDAO.getAll());
        dataBundle.setSubjects(subjectDAO.getAll());
        dataBundle.setTeachers(teacherDAO.getAll());
        dataBundle.setClassrooms(classroomDAO.getAll());
        return dataBundle;
    }

    public Object findTeacher(int idTeacher) {
        return teacherDAO.find(idTeacher);
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

    public Object findClassroom(int idClassroom) {
        return classroomDAO.find(idClassroom);
    }

    public Object findGroup(int idGroup) {
        return groupDAO.find(idGroup);
    }

    public Object findSubject(int idSubject) {
        return subjectDAO.find(idSubject);
    }
}
