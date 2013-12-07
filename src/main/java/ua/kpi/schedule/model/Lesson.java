package ua.kpi.schedule.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Anastasiia Rudyk
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Lesson implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="LESSON_ID")
    private int idLesson;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STUDENT_GROUP_ID")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    private String lessonType;

    @OneToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @OneToOne(fetch= FetchType.LAZY )
    @JoinColumn(name = "CLASSROOM_ID")
    private Classroom classroom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TIMESLOT_ID")
    private TimeSlot timeSlot;
}
