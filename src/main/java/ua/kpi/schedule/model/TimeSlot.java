package ua.kpi.schedule.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author anastasiyar
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class TimeSlot {
    @Id
    @GeneratedValue
    private int idTimeSlot;
    private int timeslotNumber;
    private int lessonNumber;
    private String startTime;
    private String endTime;
    private int dayOfWeek;
    @OneToMany(mappedBy = "timeSlot")
    private List<Lesson> lessons;

    TimeSlot(int i) {
        this.timeslotNumber = i;
    }
}
