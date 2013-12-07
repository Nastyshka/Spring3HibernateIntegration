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
    private int TIMESLOT_ID;
    private int timeslot_Number;
    private String startTime;
    private String endTime;
    private String dayOfWeek;
    @OneToMany(mappedBy = "timeSlot")
    private List<Lesson> lessons;
}
