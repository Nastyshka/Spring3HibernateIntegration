package ua.kpi.schedule.util.formatters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.schedule.dao.SubjectDAO;
import ua.kpi.schedule.model.Subject;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author AnastasiyaR
 */
@Component
public class SubjectFormatter implements Formatter<Subject> {

    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    public Subject parse(String subjectId, Locale locale) throws ParseException {
        return subjectDAO.find(new Integer(subjectId));
    }

    @Override
    public String print(Subject subject, Locale locale) {
        return subject.getNameSubject();
    }
}