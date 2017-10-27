package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A class to represent a chore.
 *
 * @author ssoper 10/27/2017
 */

@Entity
@Table(name = "chores")
public class Chore {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="choreId")
    private int choreId;
    @Column(name="chore_nme")
    private String choreName;
    @Column(name="chore_start_date")
    private LocalDate choreDate;
    @Column(name="chore_time_interval")
    private String choreInterval;
    @Column(name="assigned_to_user")
    private String assignedToUser;

    /**
     * No-argument constructor to instantiate new Chore
     */
    public Chore() {
    }

    /**
     *
     * Overloading the Chore constructor, passing in the database column values
     */
    public Chore(
            int choreId,
            String choreName,
            LocalDate choreDate,
            String choreInterval,
            String assignedToUser
    ) {
        this.choreId = choreId;
        this.choreName = choreName;
        this.choreDate = choreDate;
        this.choreInterval = choreInterval;
        this.assignedToUser = assignedToUser;
    }

    public int getChoreId() {
        return choreId;
    }

    public void setChoreId(int choreId) {
        this.choreId = choreId;
    }

    public String getChoreName() {
        return choreName;
    }

    public void setChoreName(String choreName) {
        this.choreName = choreName;
    }

    public LocalDate getChoreDate() {
        return choreDate;
    }

    public void setChoreDate(LocalDate choreDate) {
        this.choreDate = choreDate;
    }

    public String getChoreInterval() {
        return choreInterval;
    }

    public void setChoreInterval(String choreInterval) {
        this.choreInterval = choreInterval;
    }

    public String getAssignedToUser() {
        return assignedToUser;
    }

    public void setAssignedToUser(String assignedToUser) {
        this.assignedToUser = assignedToUser;
    }

    @Override
    public String toString() {
        return "Chore{" +
                "choreId=" + choreId +
                ", choreName='" + choreName + '\'' +
                ", choreDate=" + choreDate +
                ", choreInterval='" + choreInterval + '\'' +
                ", assignedToUser='" + assignedToUser + '\'' +
                '}';
    }
}
