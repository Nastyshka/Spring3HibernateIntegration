package ua.kpi.schedule.controll;

import org.jgap.InvalidConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kpi.schedule.ga.Start;
import ua.kpi.schedule.model.Classroom;
import ua.kpi.schedule.model.Group;
import ua.kpi.schedule.model.Subject;
import ua.kpi.schedule.model.Teacher;
import ua.kpi.schedule.managers.DataManager;

/**
 * @author anastasiyar
 */

@Controller
public class ScheduleController {

    @Autowired
    private DataManager dataProcessor;
    private Subject subject;

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
    public ModelAndView foundAllData () throws InvalidConfigurationException {
        ModelAndView modelAndView = new ModelAndView("/view/pages/list.jsp");
        modelAndView.addObject("foundData", dataProcessor.getAllData());
        Start.main();
        return modelAndView;
    }

    @RequestMapping("/profileSubject.do")
    public ModelAndView profileSubject (@RequestParam(value = "selectedSubject", required = false) Integer selectedSubject) {
        ModelAndView modelAndView = new ModelAndView("/view/pages/profileSubject.jsp");
        if (selectedSubject != null){
            modelAndView.addObject("command", dataProcessor.findSubject(selectedSubject));
        } else {
            modelAndView.addObject("command", new Subject());
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
            modelAndView.addObject("command", dataProcessor.findClassroom(idClassroom));
        } else {
            modelAndView.addObject("command", new Classroom());
        }
        return modelAndView;
    }

    @RequestMapping("/profileGroup.do")
    public ModelAndView profileGroup (@RequestParam(value = "idGroup", required = false) Integer idGroup) {
        ModelAndView modelAndView = new ModelAndView("/view/pages/profileGroup.jsp");
        if (idGroup != null){
            modelAndView.addObject("command", dataProcessor.findGroup(idGroup));
        } else{
            modelAndView.addObject("command", new Group());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addSubject.do", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("command")
                             Subject subject, BindingResult result) {
        dataProcessor.addSubject(subject);
        System.out.println(subject.getNameSubject() + " " + subject.getDescription());
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/addClassroom.do", method = RequestMethod.POST)
    public String addClassroom(@ModelAttribute("command")
                                   Classroom classroom, BindingResult result) {
        dataProcessor.addClassroom(classroom);
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/addGroup.do", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("command")
                               Group group, BindingResult result) {
        dataProcessor.addGroup(group);
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/addGroup.do", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("command")
                           Teacher teacher, BindingResult result) {
        dataProcessor.addTeacher(teacher);
        return "redirect:/list.do";
    }
}
