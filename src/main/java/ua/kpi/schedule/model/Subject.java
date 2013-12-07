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
@Data
@NoArgsConstructor
@ToString
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

    @ManyToMany
    @JoinTable
            (name = "GROUP_SUBJECT",
                    joinColumns =
                            {@JoinColumn(name = "SUBJECT_ID")},
                    inverseJoinColumns =
                            {@JoinColumn(name = "STUDENT_GROUP_ID")}
            )
    private List<Group> groups;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "subjects")
    private List<Teacher> teachers;
}
