package ua.kpi.schedule.controll;

import org.jgap.InvalidConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kpi.schedule.dto.DataBundle;
import ua.kpi.schedule.dto.HomePageEntity;
import ua.kpi.schedule.ga.Start;
import ua.kpi.schedule.model.*;
import ua.kpi.schedule.managers.DataManager;

import java.util.List;
import java.util.Map;

/**
 * @author anastasiyar
 */

@Controller
public class ScheduleController {

    @Autowired
    private DataManager dataProcessor;
    @Autowired
    private Start start;
    /**
     * Controller method for home page
     *
     * @return ModelAndView
     */
    @RequestMapping("/home.do")
    public String home(Map<String, Object> model, @RequestParam(value = "group", required = false) Integer idGroup) {
        DataBundle data = dataProcessor.getAllData();
        HomePageEntity hp = new HomePageEntity();

        hp.setGroups(data.getGroups());

        if(idGroup != null){
            Group group = dataProcessor.findGroup(idGroup);
            hp.setGroup(group);
            hp.setLessons(group.getLessons());
        }
        model.put("hp", hp);
        return "view/pages/index.jsp";
    }

    @RequestMapping("/home2.do")
    public String home2(Map<String, Object> model, @RequestParam(value = "teacher", required = false) Integer idTeacher) {
        DataBundle data = dataProcessor.getAllData();
        HomePageEntity hp = new HomePageEntity();

        hp.setTeachers(data.getTeachers());
        if (idTeacher != null){
            Teacher teacher = dataProcessor.findTeacher(idTeacher);
            hp.setTeacher(teacher);
            hp.setLessons(teacher.getLessons());
        }
        model.put("hp", hp);
        return "view/pages/index2.jsp";
    }

    @RequestMapping("/profileTeacher.do")
    public String profileTeacher(Map<String, Object> model, @RequestParam(value = "idTeacher", required = false) Integer idTeacher) {
//        List<String> names = new ArrayList<String>();
//        for (Subject subject : dataProcessor.getAllData().getSubjects()) {
//            names.add(subject.getNameSubject());
//        }
        model.put("allTimeslots", dataProcessor.getAllData().getTimeSlots());
        model.put("allSubjects", dataProcessor.getAllData().getSubjects());
        if (idTeacher != null) {
            model.put("teacher", dataProcessor.findTeacher(idTeacher));
        } else {
            model.put("teacher", new Teacher());
        }
        return "/view/pages/profileTeacher.jsp";
    }


    /**
     * Controller method found all teachers
     *
     * @return ModelAndView
     */
    @RequestMapping("/list.do")
    public ModelAndView foundAllData() throws InvalidConfigurationException/* throws InvalidConfigurationException*/ {
        ModelAndView modelAndView = new ModelAndView("/view/pages/list.jsp");
        modelAndView.addObject("foundData", dataProcessor.getAllData());
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

    @RequestMapping(value = "/profileTimeslot.do", method = RequestMethod.GET)
    public String profileTimeslot(Map<String, Object> model, @RequestParam(value = "selectedTimeslot", required = false) Integer selectedTimeslot){
        model.put("daysOfWeek", dataProcessor.getDaysOfWeek());
        if(selectedTimeslot!=null){
            model.put("timeslot", dataProcessor.findTimeslot(selectedTimeslot));
        } else {
            model.put("timeslot", new TimeSlot());
        }
        return "/view/pages/profileTimeslot.jsp";
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
        model.put("allSubjects", dataProcessor.getAllData().getSubjects());
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
//        for (String id : (List<String>)model.get("subjects")) {
//            teacher.getSubjects().add(dataProcessor.findSubject(new Integer(id)));
//        }
        dataProcessor.saveTeacher(teacher);
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/addTimeslot.do", method = RequestMethod.POST)
    public String addTimeslot(@ModelAttribute("timeslot")
                                  TimeSlot timeslot, BindingResult result,  Map<String, Object> model) {
        dataProcessor.saveTimeslot(timeslot);
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "/login";
    }

//    @RequestMapping(value = "/view/pages/denied.jsp", method = RequestMethod.GET)
//    public String loginerror(ModelMap model) {
//        model.addAttribute("error", "true");
//        return "/view/pages/denied.jsp";
//    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "/home.do";
    }

    @RequestMapping(value="/loginfailed.do", method = RequestMethod.GET)
         public String loginerror(ModelMap model) {

        model.addAttribute("error", "true");
        return "login.do";

    }

    @RequestMapping(value="/generate.do", method = RequestMethod.GET)
    public String generate(ModelMap model) throws InvalidConfigurationException {
        List<Lesson> lessons = start.main();
        model.addAttribute("tt", lessons);
        for (Lesson lesson : lessons){
            dataProcessor.saveLesson(lesson);
        }
        return "redirect:/home.do";
    }
}
