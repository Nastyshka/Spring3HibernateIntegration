package ua.kpi.schedule.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Anastasiia Rudyk
 */
@EqualsAndHashCode
@Entity
public class Subject implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "SUBJECT_ID")
    private int idSubject;
    private String nameSubject;
    private int amountLections;
    private int amountPractices;
    private int amountLaboratory;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
            (name = "GROUP_SUBJECT",
                    joinColumns =
                            {@JoinColumn(name = "SUBJECT_ID")},
                    inverseJoinColumns =
                            {@JoinColumn(name = "STUDENT_GROUP_ID")}
            )
    private List<Group> groups;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subjects")
    private List<Teacher> teachers;

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getAmountLections() {
        return amountLections;
    }

    public void setAmountLections(int amountLections) {
        this.amountLections = amountLections;
    }

    public int getAmountPractices() {
        return amountPractices;
    }

    public void setAmountPractices(int amountPractices) {
        this.amountPractices = amountPractices;
    }

    public int getAmountLaboratory() {
        return amountLaboratory;
    }

    public void setAmountLaboratory(int amountLaboratory) {
        this.amountLaboratory = amountLaboratory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
