package edu.matc.persistence;

import edu.matc.entity.Chore;
import edu.matc.persistence.ChoreDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 10/31/17.
 *
 * @author ssoper
 */
public class ChoreDaoTest {

    ChoreDao dao;
    int numberOfChoresInDatabase;

    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        dao = new ChoreDao();
        numberOfChoresInDatabase = dao.getAllChores().size();
    }

    @Test
    public void getAllChoresTest() throws Exception {
        List<Chore> chores = dao.getAllChores();
        assertTrue(chores.size() > 0);
    }

    @Test
    public void getChoreTest() throws Exception {
        Chore chore = dao.getChore(1);
        assertNotNull("Chore with id of value 1 wasn't found", chore);
        assertEquals("mow the lawn Chore was not returned", "mow the lawn", chore.getChoreName());
    }

    @Test
    public void addChoreTest() throws Exception {
        Chore chore = new Chore();
        chore.setChoreId(45);
        chore.setChoreName("testChore");

        int newIdForNewChore = dao.addChore(chore);
        Chore actualChore = dao.getChore(newIdForNewChore);
        assertNotNull("New test chore not inserted.", actualChore);
        assertEquals("New test chore wasn't added in the right spot", "testChore",actualChore.getChoreName());
        assertEquals("Number of rows didn't increase.", numberOfChoresInDatabase + 1, dao.getAllChores().size());
    }

    @Test
    public void deleteChoreTest() throws Exception {

        // TODO Should probably add a temporary chore before deleting so I can run this more than once
        Chore chore = dao.getChore(45);
        assertTrue(chore != null);
        dao.deleteChore(45);
        chore = dao.getChore(45);
        assertTrue(chore == null);
    }

    @Test
    public void updateChoreTest() throws Exception {
        Chore chore = dao.getChore(4);
        assertTrue(chore != null);
        chore.setChoreName("anotherTestChore");
        dao.updateChore(chore);
        chore = dao.getChore(4);
        assertTrue(chore != null);
        assertEquals("The chore name wasn't successfully updated.", "anotherTestChore", chore.getChoreName());
    }

    //TODO use .equals() on each entity for easy testing - insert a chore to the db and read it back
}
