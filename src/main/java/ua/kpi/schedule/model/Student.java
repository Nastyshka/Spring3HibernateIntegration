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
@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Student extends User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    protected int idStudent;

    @ManyToOne
    @JoinColumn(name = "STUDENTGROUP_ID")
    private Group group;

    @Transient
    private List<Lesson> lessons;
}
