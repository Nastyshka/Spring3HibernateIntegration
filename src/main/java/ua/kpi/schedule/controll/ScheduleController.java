package ua.kpi.schedule.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kpi.schedule.model.Group;
import ua.kpi.schedule.model.Subject;
import ua.kpi.schedule.model.Teacher;
import ua.kpi.schedule.processors.DataProcessor;

/**
 * @author anastasiyar
 */

@Controller
public class ScheduleController {

    @Autowired
    private DataProcessor dataProcessor;

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
    public ModelAndView foundAllData () {
        ModelAndView modelAndView = new ModelAndView("/view/pages/list.jsp");
        modelAndView.addObject("foundData", dataProcessor.getAllData());
        return modelAndView;
    }

    @RequestMapping("/profileSubject.do")
    public ModelAndView profileSubject (@RequestParam(value = "idSubject", required = false) Integer idSubject) {
        ModelAndView modelAndView = new ModelAndView("/view/pages/profileSubject.jsp");
        if (idSubject != null){
            modelAndView.addObject("foundSubject", dataProcessor.findSubject(idSubject));
        } else {
            modelAndView.addObject("foundSubject", new Subject());
        }
        return modelAndView;
    }

    @RequestMapping("/profileTeacher.do")
    public ModelAndView profileTeacher (@RequestParam(value = "idTeacher", required = false) Integer idTeacher) {
        ModelAndView modelAndView = new ModelAndView("/view/pages/profileTeacher.jsp");
        if (idTeacher != null){
            modelAndView.addObject("foundTeacher", dataProcessor.findTeacher(idTeacher));
        } else {
            modelAndView.addObject("foundTeacher", new Teacher());
        }
        return modelAndView;
    }

    @RequestMapping("/profileClassroom.do")
    public ModelAndView profileClassroom (@RequestParam(value = "idClassroom", required = false) Integer idClassroom) {
        ModelAndView modelAndView = new ModelAndView("/view/pages/profileClassroom.jsp");
        if (idClassroom != null){
            modelAndView.addObject("foundClassroom", dataProcessor.findClassroom(idClassroom));
        } else {
            modelAndView.addObject("foundClassroom", new Subject());
        }
        return modelAndView;
    }

    @RequestMapping("/profileGroup.do")
    public ModelAndView profileGroup (@RequestParam(value = "idGroup", required = false) Integer idGroup) {
        ModelAndView modelAndView = new ModelAndView("/view/pages/profileGroup.jsp");
        if (idGroup != null){
            modelAndView.addObject("foundGroup", dataProcessor.findGroup(idGroup));
        } else{
            modelAndView.addObject("foundGroup", new Group());
        }
        return modelAndView;
    }
}
