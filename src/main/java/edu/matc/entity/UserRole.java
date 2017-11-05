package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user.
 *
 * @author ssoper 10/3/2017
 */

@Entity
@Table(name = "user_roles")
public class UserRole {

    private int userRoleId;
    private String userRoleName;
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

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="user_role_id")
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name="user_name")
    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    @Basic
    @Column(name = "role_name")
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

        if (userRoleId != userRole.userRoleId) return false;
        if (userRoleName != null ? !userRoleName.equals(userRole.userRoleName) : userRole.userRoleName != null)
            return false;
        return roleName != null ? roleName.equals(userRole.roleName) : userRole.roleName == null;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + (userRoleName != null ? userRoleName.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
