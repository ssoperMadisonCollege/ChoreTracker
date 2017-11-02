package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * A class to represent a user.
 *
 * @author ssoper 10/3/2017
 */

@Entity
@Table(name = "user_roles")
public class UserRole {

    // TODO need to add an ID column to the user_roles table
    @Column(name="user_name")
    private String userRoleName;
    @Column(name = "role_name")
    private String roleName;

    /**
     * No-argument constructor to instantiate new UserRole
     */
    public UserRole() {
    }

    /**
     * Overloading the User constructor, passing in the database column values
     */
    public UserRole(String userRoleName, String roleName) {
        this.userRoleName = userRoleName;
        this.roleName = roleName;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleName='" + userRoleName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
