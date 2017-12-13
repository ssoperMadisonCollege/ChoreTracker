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
    private String roleName;
    private User user;

    /**
     * Instantiates a new User role.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new User role.
     *
     * @param user     the user
     * @param roleName the role name
     */
    public UserRole(User user, String roleName) {
        this.user = user;
        this.roleName = roleName;
    }

    /**
     * Instantiates a new User role.
     *
     * @param userRoleId the user role id
     * @param user       the user
     * @param roleName   the role name
     */
    public UserRole(int userRoleId, User user, String roleName) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.roleName = roleName;
    }

    /**
     * Gets user role id.
     *
     * @return the user role id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "user_role_id")
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
     * Gets user.
     *
     * @return the user
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", nullable = false)
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
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
                ", roleName='" + roleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (userRoleId != userRole.userRoleId) return false;
        return roleName != null ? roleName.equals(userRole.roleName) : userRole.roleName == null;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}