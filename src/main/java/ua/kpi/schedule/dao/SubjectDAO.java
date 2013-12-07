package ua.kpi.schedule.dao;

import ua.kpi.schedule.model.Subject;

/**
 * Created with IntelliJ IDEA.
 * User: Me
 * Date: 28.11.13
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class SubjectDAO extends GenericDAO<Subject>{
    SubjectDAO(){
        super(Subject.class);
    }
}
