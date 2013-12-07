package ua.kpi.schedule.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.kpi.schedule.model.Classroom;

/**
 * Created with IntelliJ IDEA.
 * User: Me
 * Date: 28.11.13
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ClassroomDAO extends GenericDAO<Classroom> {

    private SessionFactory eManager;

    ClassroomDAO(){
        super(Classroom.class);
    }

    public void seteManager(SessionFactory eManager) {
        this.eManager = eManager;
    }
}
