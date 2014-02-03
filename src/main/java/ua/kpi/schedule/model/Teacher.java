package ua.kpi.schedule.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @ManyToMany(cascade = CascadeType.ALL) @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable
            (name = "TEACHER_TRACK",
            joinColumns =
                    {@JoinColumn(name="TEACHER_ID")},
            inverseJoinColumns =
                    {@JoinColumn(name = "SUBJECT_ID")})
    private List<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher") @LazyCollection(LazyCollectionOption.FALSE)
    private List<Lesson> lessons;

    @ManyToMany(cascade = CascadeType.ALL)  @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable
            (name = "TEACHER_AVAILABLE_TS",
                    joinColumns =
                            {@JoinColumn(name="TEACHER_ID")},
                    inverseJoinColumns =
                            {@JoinColumn(name = "TS_ID")})
    private List<TimeSlot> availableTimeslots;

    public List<TimeSlot> getAvailableTimeslots() {
        return availableTimeslots;
    }

    protected String nameUser;
    protected String eMail;
    protected String telephoneNumber;

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

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Teacher() {
    }
}
