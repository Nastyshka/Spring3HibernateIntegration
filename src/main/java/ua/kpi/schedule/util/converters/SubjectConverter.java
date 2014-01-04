package ua.kpi.schedule.util.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.kpi.schedule.dao.SubjectDAO;
import ua.kpi.schedule.model.Subject;

/**
 * Created with IntelliJ IDEA.
 * User: Nastyshka
 * Date: 04.01.14
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
@Component("subjectConverter")
public class SubjectConverter implements Converter<String, Subject> {

    @Autowired
    SubjectDAO subjectDAO;

    @Override
    public Subject convert(String id) {
        return subjectDAO.find(new Integer(id));

    }
}
