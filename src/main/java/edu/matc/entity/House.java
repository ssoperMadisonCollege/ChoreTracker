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
public class House {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="houseId")
    private int houseId;
    @Column(name="house_name")
    private String houseName;

    /**
     * No-argument constructor to instantiate new House
     */
    public House() {
    }

    /**
     *
     * Overloading the House constructor, passing in the database column values
     */
    public House(
            int houseId,
            String houseName
    ) {
        this.houseId = houseId;
        this.houseName = houseName;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", houseName='" + houseName + '\'' +
                '}';
    }
}
