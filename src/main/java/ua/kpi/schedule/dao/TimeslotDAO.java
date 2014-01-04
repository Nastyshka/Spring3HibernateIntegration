package ua.kpi.schedule.dao;

import ua.kpi.schedule.model.TimeSlot;

/**
 * Created with IntelliJ IDEA.
 * User: Nastyshka
 * Date: 04.01.14
 * Time: 19:28
 * To change this template use File | Settings | File Templates.
 */
public class TimeslotDAO extends GenericDAO<TimeSlot> {

    public TimeslotDAO() {
        super(TimeSlot.class);
    }
}
