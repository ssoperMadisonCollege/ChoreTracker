package edu.matc.persistence;

import edu.matc.entity.House;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * The House dao test.
 *
 * Created on 10/31/17.
 *
 * @author ssoper
 */
public class HouseDaoTest {

    HouseDao dao;
    int numberOfHousesInDatabase;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        dao = new HouseDao();
        numberOfHousesInDatabase = dao.getAllHouses().size();
    }

    /**
     * Get all houses test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllHousesTest() throws Exception {
        List<House> houses = dao.getAllHouses();
        assertTrue(houses.size() > 0);
    }

    /**
     * Get house test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getHouseTest() throws Exception {
        House house = dao.getHouse(2);
        assertNotNull("House with id of value 1 wasn't found", house);
        assertEquals("Pelton was not returned", "Pelton House", house.getHouseName());
    }


    /**
     * Add house test.
     *
     * @throws Exception the exception
     */
    @Test
    public void addHouseTest() throws Exception {

        // Create a user, add it to the database
        User user = new User(7,"Liz", "Pelton", "password", "lpelton@wifeMail.com", "608-111-2222", "lpelton");
        UserDao userDao = new UserDao();
        userDao.addUser(user);
        log.info("Added the user to user dao: " + user);

        // Create a house, add it to the database
        House house = new House(8,"testHouse", user);
        dao.addHouse(house);
        log.info("Added the house to house dao: " + house);

        // get the added user role
        House newHouse = dao.getHouse(8);
        assertTrue(house.equals(newHouse));
    }

    /**
     * Delete house test.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteHouseTest() throws Exception {

        House house = dao.getHouse(5);
        assertTrue(house != null);
        dao.deleteHouse(5);
        house = dao.getHouse(5);
        assertTrue(house == null);
    }

    /**
     * Update house test.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateHouseTest() throws Exception {
        House house = dao.getHouse(4);
        assertTrue(house != null);
        house.setHouseName("anotherTestHouse");
        dao.updateHouse(house);
        house = dao.getHouse(4);
        assertTrue(house != null);
        assertEquals("The house name wasn't successfully updated.", "anotherTestHouse", house.getHouseName());
    }

    //TODO use .equals() on each entity for easy testing - insert a house to the db and read it back
}
