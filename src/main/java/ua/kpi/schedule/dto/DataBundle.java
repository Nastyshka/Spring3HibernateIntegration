package ua.kpi.schedule.dto;

import ua.kpi.schedule.model.Classroom;
import ua.kpi.schedule.model.Group;
import ua.kpi.schedule.model.Subject;
import ua.kpi.schedule.model.Teacher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nastyshka
 * Date: 07.12.13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
public class DataBundle {
    private List<Teacher> teachers;
    private List<Subject> subjects;
    private List<Group> groups;
    private List<Classroom> classrooms;

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
