package ua.kpi.schedule.dto;

import ua.kpi.schedule.model.Group;
import ua.kpi.schedule.model.Lesson;
import ua.kpi.schedule.model.Teacher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nastyshka
 * Date: 02.02.14
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public class HomePageEntity {
    private String radio;
    private Group group;
    private Teacher teacher;
    private List<Group> groups;
    private List<Teacher> teachers;
    private List<Lesson> lessons;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }
}
