package ua.kpi.schedule.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Anastasiia Rudyk
 */
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "STUDENT_GROUPS")
public class Group implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_GROUP_ID")
    protected int idStudentGroup;

    private String nameGroup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "groups", fetch = FetchType.LAZY)
    private List<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.LAZY)
    private List<Lesson> lessons;

    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public int getIdStudentGroup() {
        return idStudentGroup;
    }

    public void setIdStudentGroup(int idStudentGroup) {
        this.idStudentGroup = idStudentGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

}
