package ua.kpi.schedule.dao;

import ua.kpi.schedule.model.Lesson;

/**
 * Created with IntelliJ IDEA.
 * User: Me
 * Date: 28.11.13
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */
public class LessonDAO extends GenericDAO<Lesson>{
    LessonDAO(){
        super(Lesson.class);
    }
}
