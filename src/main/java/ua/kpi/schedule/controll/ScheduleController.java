package ua.kpi.schedule.controll;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kpi.schedule.dao.GroupDAO;
import ua.kpi.schedule.dao.SubjectDAO;
import ua.kpi.schedule.dao.TeacherDAO;

/**
 * @author anastasiyar
 */

@Controller
public class ScheduleController {
    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private SubjectDAO subjectDAO;
    /**
     * Controller method for home page
     * @return ModelAndView
     */
    @RequestMapping("/home.do")
    public ModelAndView home (){
        return new ModelAndView("view/pages/index.jsp");
    }

    /**
     * Controller method found all teachers
     * @return ModelAndView
     */
    @RequestMapping("/list.do")
    public ModelAndView foundTeachers () {
        ModelAndView modelAndView = new ModelAndView("/view/pages/list.jsp");
        modelAndView.addObject("foundTeachers", teacherDAO.getAll());
        return modelAndView;
    }

    @RequestMapping("/profileTeacher.do")
    public ModelAndView profileTeacher (@RequestParam int idTeacher) {
        ModelAndView modelAndView = new ModelAndView("/view/pages/profileTeacher.jsp");
        modelAndView.addObject("foundTeachers", teacherDAO.find(idTeacher));
        return modelAndView;
    }
}
