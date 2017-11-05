package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 10/3/17.
 *
 * @author ssoper
 */
public class UserDaoTest {

    UserDao dao;
    int numberOfUsersInDatabase;

    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        dao = new UserDao();
        numberOfUsersInDatabase = dao.getAllUsers().size();
    }

    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUserTest() throws Exception {
        User user = dao.getUser(4);
        assertNotNull("User with id of value 4 wasn't found", user);
        assertEquals("Mack was not returned", "Mack", user.getLastName());
    }

    @Test
    public void deleteUserTest() throws Exception {

        // TODO Should probably add a temporary user before deleting so I can run this more than once
        User user = dao.getUser(6);
        assertTrue(user != null);
        dao.deleteUser(6);
        user = dao.getUser(6);
        assertTrue(user == null);
    }

    @Test
    public void addUserTest() throws Exception {
        User user = new User();
        user.setUserId(26);
        user.setFirstName("Sam");
        user.setLastName("Soper");
        user.setPassword("password");
        user.setEmail("silly@email.joke");
        user.setPhone("867-5309");
        user.setUserName("ssoper");

        int newIdForNewUser = dao.addUser(user);
        User actualUser = dao.getUser(newIdForNewUser);
        assertNotNull("New test user not inserted.", actualUser);
        assertEquals("New test user wasn't added in the right spot", "Soper",actualUser.getLastName());
        assertEquals("Number of rows didn't increase.", numberOfUsersInDatabase + 1, dao.getAllUsers().size());
    }

    @Test
    public void updateUserTest() throws Exception {
        User user = dao.getUser(2);
        assertTrue(user != null);
        user.setFirstName("Foo_bar");
        dao.updateUser(user);
        user = dao.getUser(2);
        assertTrue(user != null);
        assertEquals("The first name wasn't successfully updated.", "Foo_bar", user.getFirstName());
    }

    //TODO use .equals() on each entity for easy testing - insert a user to the db and read it back
}