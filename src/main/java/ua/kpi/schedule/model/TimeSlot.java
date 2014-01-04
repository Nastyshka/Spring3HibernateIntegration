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
    private String dayOfWeek;
    @OneToMany(mappedBy = "timeSlot")
    private List<Lesson> lessons;

    TimeSlot(int i) {
        this.timeslotNumber = i;
    }

    public TimeSlot() {
    }

    public int getIdTimeSlot() {
        return idTimeSlot;
    }

    public void setIdTimeSlot(int idTimeSlot) {
        this.idTimeSlot = idTimeSlot;
    }

    public int getTimeslotNumber() {
        return timeslotNumber;
    }

    public void setTimeslotNumber(int timeslotNumber) {
        this.timeslotNumber = timeslotNumber;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
