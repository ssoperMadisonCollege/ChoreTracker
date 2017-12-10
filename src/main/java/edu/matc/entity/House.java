package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A class to represent a house.
 *
 * @author ssoper 10/27/2017
 */
@Entity
@Table(name = "houses")
public class House implements Serializable {


    private int houseId;
    private String houseName;
    private User user;

    /**
     * No-argument constructor to instantiate new House
     */
    public House() {
    }

    /**
     * Partial constructor.
     *
     * @param houseName the house name
     * @param user the username
     */
    public House(
            String houseName,
            User user
    ) {
        this.houseName = houseName;
        this.user = user;
    }

    /**
     * Full constructor.
     *
     * @param houseId   the house id
     * @param houseName the house name
     * @param user the username
     */
    public House(
            int houseId,
            String houseName,
            User user
    ) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.user = user;
    }

    /**
     * Gets house id.
     *
     * @return the house id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="houseId")
    public int getHouseId() {
        return houseId;
    }

    /**
     * Sets house id.
     *
     * @param houseId the house id
     */
    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    /**
     * Gets house name.
     *
     * @return the house name
     */
    @Basic
    @Column(name="house_name")
    public String getHouseName() {
        return houseName;
    }

    /**
     * Sets house name.
     *
     * @param houseName the house name
     */
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", houseName='" + houseName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;

        House house = (House) o;

        if (houseId != house.houseId) return false;
        return houseName != null ? houseName.equals(house.houseName) : house.houseName == null;
    }

    @Override
    public int hashCode() {
        int result = houseId;
        result = 31 * result + (houseName != null ? houseName.hashCode() : 0);
        return result;
    }
}
