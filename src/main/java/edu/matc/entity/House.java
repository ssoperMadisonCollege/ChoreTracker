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

    /**
     * No-argument constructor to instantiate new House
     */
    public House() {
    }

    /**
     * Overloading the House constructor, passing in the database column values
     */
    public House(
            int houseId,
            String houseName
    ) {
        this.houseId = houseId;
        this.houseName = houseName;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="houseId")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name="house_name")
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
