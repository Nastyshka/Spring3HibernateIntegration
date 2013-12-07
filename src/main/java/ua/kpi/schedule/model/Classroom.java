package ua.kpi.schedule.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Anastasiia Rudyk
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Classroom implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="CLASSROOM_ID")
    private int CLASSROOM_ID;
    private String address;
    private String type;
    private String number;
}
