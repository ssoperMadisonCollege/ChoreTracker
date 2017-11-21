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
public class UserRole implements Serializable {

    private int userRoleId;
    private String userRoleName;
    private String roleName;

    /**
     * No-argument constructor to instantiate new UserRole
     */
    public UserRole() {
    }

    /**
     * Partial constructor
     *
     * @param userRoleName the user role name
     * @param roleName     the role name
     */
    public UserRole(String userRoleName, String roleName) {
        this.userRoleName = userRoleName;
        this.roleName = roleName;
    }

    /**
     * Full constructor
     *
     * @param userRoleName the user role name
     * @param roleName     the role name
     */
    public UserRole(int userRoleId, String userRoleName, String roleName) {
        this.userRoleId = userRoleId;
        this.userRoleName = userRoleName;
        this.roleName = roleName;
    }

    /**
     * Gets user role id.
     *
     * @return the user role id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="user_role_id")
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets user role id.
     *
     * @param userRoleId the user role id
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Gets user role name.
     *
     * @return the user role name
     */
    @Basic
    @Column(name="user_name")
    public String getUserRoleName() {
        return userRoleName;
    }

    /**
     * Sets user role name.
     *
     * @param userRoleName the user role name
     */
    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
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
        if (!(o instanceof UserRole)) return false;

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
