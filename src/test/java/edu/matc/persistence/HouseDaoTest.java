package edu.matc.persistence;

import edu.matc.entity.House;
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
        House house = dao.getHouse(1);
        assertNotNull("House with id of value 1 wasn't found", house);
        assertEquals("Soper House was not returned", "Soper House", house.getHouseName());
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
     * Add house test.
     *
     * @throws Exception the exception
     */
    @Test
    public void addHouseTest() throws Exception {
        House house = new House();
        house.setHouseId(45);
        house.setHouseName("testHouse");

        int newIdForNewHouse = dao.addHouse(house);
        House actualHouse = dao.getHouse(newIdForNewHouse);
        assertNotNull("New test house not inserted.", actualHouse);
        assertEquals("New test house wasn't added in the right spot", "testHouse",actualHouse.getHouseName());
        assertEquals("Number of rows didn't increase.", numberOfHousesInDatabase + 1, dao.getAllHouses().size());
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
