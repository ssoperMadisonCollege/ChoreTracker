package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import edu.matc.util.LocalDateAttributeConverter;
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
    @Column(name="chore_name")
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

    @Convert(converter = LocalDateAttributeConverter.class)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

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
