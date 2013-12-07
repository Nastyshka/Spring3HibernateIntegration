package ua.kpi.schedule.dao;

import ua.kpi.schedule.model.Teacher;

/**
 * Created with IntelliJ IDEA.
 * User: Me
 * Date: 28.11.13
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
public class TeacherDAO extends GenericDAO<Teacher> {
    TeacherDAO(){
        super(Teacher.class);
    }
}
