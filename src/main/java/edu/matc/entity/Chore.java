package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import edu.matc.util.LocalDateAttributeConverter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A class to represent a chore.
 *
 * @author ssoper 10/27/2017
 */
@Entity
@Table(name = "chores")
public class Chore implements Serializable {

    private int choreId;
    private String choreName;
    private LocalDate choreDate;
    private String choreInterval;
    private String assignedToUser;

    /**
     * No-argument constructor to instantiate new Chore
     */
    public Chore() {
    }

    /**
     * Overloading the Chore constructor, passing in the database column values
     *
     * @param choreId        the chore id
     * @param choreName      the chore name
     * @param choreDate      the chore date
     * @param choreInterval  the chore interval
     * @param assignedToUser the assigned to user
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


    /**
     * Gets chore id.
     *
     * @return the chore id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="choreId")
    public int getChoreId() {
        return choreId;
    }

    /**
     * Sets chore id.
     *
     * @param choreId the chore id
     */
    public void setChoreId(int choreId) {
        this.choreId = choreId;
    }

    /**
     * Gets chore name.
     *
     * @return the chore name
     */
    @Basic
    @Column(name="chore_name")
    public String getChoreName() {
        return choreName;
    }

    /**
     * Sets chore name.
     *
     * @param choreName the chore name
     */
    public void setChoreName(String choreName) {
        this.choreName = choreName;
    }

    /**
     * Gets chore date.
     *
     * @return the chore date
     */
    @Basic
    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name="chore_start_date")
    public LocalDate getChoreDate() {
        return choreDate;
    }

    /**
     * Sets chore date.
     *
     * @param choreDate the chore date
     */
    public void setChoreDate(LocalDate choreDate) {
        this.choreDate = choreDate;
    }

    /**
     * Gets chore interval.
     *
     * @return the chore interval
     */
    @Basic
    @Column(name="chore_time_interval")
    public String getChoreInterval() {
        return choreInterval;
    }

    /**
     * Sets chore interval.
     *
     * @param choreInterval the chore interval
     */
    public void setChoreInterval(String choreInterval) {
        this.choreInterval = choreInterval;
    }

    /**
     * Gets assigned to user.
     *
     * @return the assigned to user
     */
    @Basic
    @Column(name="assigned_to_user")
    public String getAssignedToUser() {
        return assignedToUser;
    }

    /**
     * Sets assigned to user.
     *
     * @param assignedToUser the assigned to user
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chore)) return false;

        Chore chore = (Chore) o;

        if (choreId != chore.choreId) return false;
        if (choreName != null ? !choreName.equals(chore.choreName) : chore.choreName != null) return false;
        if (choreDate != null ? !choreDate.equals(chore.choreDate) : chore.choreDate != null) return false;
        if (choreInterval != null ? !choreInterval.equals(chore.choreInterval) : chore.choreInterval != null)
            return false;
        return assignedToUser != null ? assignedToUser.equals(chore.assignedToUser) : chore.assignedToUser == null;
    }

    @Override
    public int hashCode() {
        int result = choreId;
        result = 31 * result + (choreName != null ? choreName.hashCode() : 0);
        result = 31 * result + (choreDate != null ? choreDate.hashCode() : 0);
        result = 31 * result + (choreInterval != null ? choreInterval.hashCode() : 0);
        result = 31 * result + (assignedToUser != null ? assignedToUser.hashCode() : 0);
        return result;
    }
}
