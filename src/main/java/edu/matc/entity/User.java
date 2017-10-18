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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="userId")
    private int userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_phone")
    private String phone;
    @Column(name = "user_name")
    private String userName;

    /**
     * No-argument constructor to instantiate new User
     */
    public User() {
    }

    /**
     *
     * Overloading the User constructor, passing in the database column values
     */
    public User(int userId,
                String firstName,
                String lastName,
                String password,
                String email,
                String phone) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }


}
