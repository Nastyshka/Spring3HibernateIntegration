package ua.kpi.schedule.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Anastasiia Rudyk
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class User implements Serializable{
    protected String nameUser;
    protected String secondName;
    protected String login;
    protected String password;
    protected String eMail;
    protected String telephoneNumber;
    protected String Adress;
}
