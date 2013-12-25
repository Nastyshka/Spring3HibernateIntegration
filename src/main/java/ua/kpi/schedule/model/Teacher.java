package ua.kpi.schedule.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author Anastasiia Rudyk
 */
@EqualsAndHashCode
@Entity
public class Teacher extends User {

    @Id
    @GeneratedValue
    @Column(name = "TEACHER_ID")
    protected int idTeacher;

    private String academicTitle;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable
            (name = "TEACHER_TRACK",
            joinColumns =
                    {@JoinColumn(name="TEACHER_ID")},
            inverseJoinColumns =
                    {@JoinColumn(name = "SUBJECT_ID")})
    private List<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Lesson> lessons;

    //TODO: temporary solution
    @Transient
    private List<TimeSlot> availableTimeslots;

    public List<TimeSlot> getAvailableTimeslots() {
        return availableTimeslots;
    }

    public void setAvailableTimeslots(List<TimeSlot> availableTimeslots) {
        this.availableTimeslots = availableTimeslots;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
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

    public Teacher() {
    }
}
