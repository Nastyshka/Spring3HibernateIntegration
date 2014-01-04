package ua.kpi.schedule.util.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.kpi.schedule.dao.TimeslotDAO;
import ua.kpi.schedule.model.TimeSlot;

/**
 * Created with IntelliJ IDEA.
 * User: Nastyshka
 * Date: 04.01.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
@Component("timeslotConverter")
public class TimeslotConverter implements Converter<String, TimeSlot> {

    @Autowired
    TimeslotDAO timeslotDAO;

    @Override
    public TimeSlot convert(String source) {
        return timeslotDAO.find(new Integer(source));
    }
}
