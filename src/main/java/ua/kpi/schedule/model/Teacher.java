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
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Teacher extends User {

    @Id
    @GeneratedValue
    @Column(name = "TEACHER_ID")
    protected int idTeacher;

    private String academicTitle;

    @ManyToMany
    @JoinTable
            (name = "TEACHER_TRACK",
            joinColumns =
                    {@JoinColumn(name="TEACHER_ID")},
            inverseJoinColumns =
                    {@JoinColumn(name = "SUBJECT_ID")})
    private List<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Lesson> lessons;
}
