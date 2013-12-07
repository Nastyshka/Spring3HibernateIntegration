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
@Table(name = "STUDENT_GROUPS")
public class Group implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_GROUP_ID")
    protected int idStudentGroup;

    private String nameGroup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private List<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Lesson> lessons;
}
