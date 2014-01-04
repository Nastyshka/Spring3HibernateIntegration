package ua.kpi.schedule.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kpi.schedule.model.Classroom;
import ua.kpi.schedule.model.Group;
import ua.kpi.schedule.model.Subject;
import ua.kpi.schedule.model.Teacher;
import ua.kpi.schedule.managers.DataManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author anastasiyar
 */

@Controller
public class ScheduleController {

    @Autowired
    private DataManager dataProcessor;
    private Subject command;

    public Subject getCommand() {
        return command;
    }

    public void setCommand(Subject command) {
        this.command = command;
    }

    /**
     * Controller method for home page
     *
     * @return ModelAndView
     */
    @RequestMapping("/home.do")
    public ModelAndView home() {
        return new ModelAndView("view/pages/index.jsp");
    }

    /**
     * Controller method found all teachers
     *
     * @return ModelAndView
     */
    @RequestMapping("/list.do")
    public ModelAndView foundAllData()/* throws InvalidConfigurationException*/ {
        ModelAndView modelAndView = new ModelAndView("/view/pages/list.jsp");
        modelAndView.addObject("foundData", dataProcessor.getAllData());
//        Start.main();
        return modelAndView;
    }

    @RequestMapping(value = "/profileSubject.do", method = RequestMethod.GET)
    public String profileSubject (Map<String, Object> model, @RequestParam(value = "selectedSubject", required = false) Integer selectedSubject){
    if(selectedSubject!=null){
          model.put("subject", dataProcessor.findSubject(selectedSubject));
    } else {
        model.put("subject", new Subject());
    }
    return "/view/pages/profileSubject.jsp";
}

    @RequestMapping("/profileTeacher.do")
    public String profileTeacher(Map<String, Object> model, @RequestParam(value = "idTeacher", required = false) Integer idTeacher) {
//        ModelAndView modelAndView = new ModelAndView("/view/pages/profileTeacher.jsp");
        List<String> names = new ArrayList<String>();
        for (Subject subject : dataProcessor.getAllData().getSubjects()) {
            names.add(subject.getNameSubject());
        }
        model.put("allSubjects", dataProcessor.getAllData().getSubjects());
        if (idTeacher != null) {
            model.put("teacher", dataProcessor.findTeacher(idTeacher));
        } else {
            model.put("teacher", new Teacher());
        }
        return "/view/pages/profileTeacher.jsp";
    }

    @RequestMapping(value = "/profileClassroom.do", method = RequestMethod.GET)
    public String profileClassroom(Map<String, Object> model, @RequestParam(value = "selectedClassroom", required = false) Integer idClassroom) {
//        ModelAndView modelAndView = new ModelAndView("/view/pages/profileClassroom.jsp");
        if (idClassroom != null) {
            model.put("classroom", dataProcessor.findClassroom(idClassroom));
        } else {
            model.put("classroom", new Classroom());
        }
        return "/view/pages/profileClassroom.jsp";
    }

    @RequestMapping(value = "/profileGroup.do", method = RequestMethod.GET)
    public String profileGroup
            (@RequestParam(value = "selectedGroup", required = false) Integer idGroup, Map<String, Object> model) {
//        ModelAndView modelAndView = new ModelAndView("/view/pages/profileGroup.jsp");
        if (idGroup != null) {
            model.put("group", dataProcessor.findGroup(idGroup));
        } else {
            model.put("group", new Group());
        }
        return "/view/pages/profileGroup.jsp";
    }

    @RequestMapping(value = "/addSubject.do", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("subject")
                             Subject subject, Map<String, Object> model) {
        dataProcessor.saveSubject(subject);
        System.out.println(subject.getNameSubject() + " " + subject.getDescription());
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/addClassroom.do", method = RequestMethod.POST)
    public String addClassroom(@ModelAttribute("classroom")
                               Classroom classroom, Map<String, Object> model) {
        dataProcessor.saveClassroom(classroom);
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/addGroup.do", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("group")
                           Group group, Map<String, Object> model) {
        dataProcessor.saveGroup(group);
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/addTeacher.do", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("teacher")
                             Teacher teacher, BindingResult result,  Map<String, Object> model) {
        for (String id : (List<String>)model.get("subjects")) {
            teacher.getSubjects().add(dataProcessor.findSubject(new Integer(id)));
        }
        dataProcessor.saveTeacher(teacher);
        return "redirect:/list.do";
    }
}
