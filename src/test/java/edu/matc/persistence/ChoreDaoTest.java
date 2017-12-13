package edu.matc.persistence;

import edu.matc.entity.Chore;
import javafx.util.converter.LocalDateStringConverter;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The Chore dao test.
 *
 * Created on 10/31/17.
 *
 * @author ssoper
 */
public class ChoreDaoTest {

    ChoreDao dao;
    int numberOfChoresInDatabase;
    private final Logger log = Logger.getLogger(this.getClass());
    private LocalDateStringConverter dateConverter = new LocalDateStringConverter();

    @Before
    public void setup() {
        dao = new ChoreDao();
        numberOfChoresInDatabase = dao.getAllChores().size();
    }

    /**
     * Get all chores test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllChoresTest() throws Exception {
        List<Chore> chores = dao.getAllChores();
        assertTrue(chores.size() > 0);
    }

    /**
     * Get chore test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getChoreTest() throws Exception {
        Chore chore = dao.getChore(1);
        assertNotNull("Chore with id of value 1 wasn't found", chore);
        assertEquals("mow the lawn Chore was not returned", "mow the lawn", chore.getChoreName());
    }

    /**
     * Delete chore test.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteChoreTest() throws Exception {

        Chore chore = dao.getChore(5);
        assertTrue(chore != null);
        dao.deleteChore(5);
        chore = dao.getChore(5);
        assertTrue(chore == null);
    }

    /**
     * Add chore test.
     *
     * @throws Exception the exception
     */
    @Test
    public void addChoreTest() throws Exception {
        Chore expected = new Chore();

        // Expected
        expected.setChoreId(5);
        expected.setChoreName("fix leaky garage door");
        expected.setChoreDate(dateConverter.fromString("10/21/2017"));

        // Actual
        int newChore = dao.addChore(expected);
        Chore actualChore = dao.getChore(newChore);
        
        assertNotNull("New test chore not inserted.", actualChore);
        assertEquals("New test chore wasn't added in the right spot", "fix leaky garage door",actualChore.getChoreName());
        assertEquals("Number of rows didn't increase.", numberOfChoresInDatabase + 1, dao.getAllChores().size());
    }

    /**
     * Update chore test.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateChoreTest() throws Exception {
        Chore chore = dao.getChore(5);
        assertTrue(chore != null);
        chore.setChoreName("anotherTestChore");
        dao.updateChore(chore);
        chore = dao.getChore(5);
        assertTrue(chore != null);
        assertEquals("The chore name wasn't successfully updated.", "anotherTestChore", chore.getChoreName());
    }
}
