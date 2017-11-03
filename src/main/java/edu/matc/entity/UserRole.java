package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * A class to represent a user.
 *
 * @author ssoper 10/3/2017
 */

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="user_role_id")
    private int userRoleId;
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
        this.userRoleId = userRoleId;
        this.userRoleName = userRoleName;
        this.roleName = roleName;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
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
                "userRoleId=" + userRoleId +
                ", userRoleName='" + userRoleName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return userRoleId == userRole.userRoleId &&
                Objects.equals(userRoleName, userRole.userRoleName) &&
                Objects.equals(roleName, userRole.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleId, userRoleName, roleName);
    }
}
