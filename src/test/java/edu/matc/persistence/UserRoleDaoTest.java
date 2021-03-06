package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * The UserRole userRoleDao test.
 *
 * Created on 10/3/17.
 *
 * @author ssoper
 */
public class UserRoleDaoTest {

    UserRoleDao userRoleDao;
    int numberOfUserRolesInDatabase;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        userRoleDao = new UserRoleDao();
        numberOfUserRolesInDatabase = userRoleDao.getAllUserRoles().size();
    }

    /**
     * Get all user roles test.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUserRoles() throws Exception {
        List<UserRole> userRoles = userRoleDao.getAllUserRoles();
        assertTrue(userRoles.size() > 0);
        for (UserRole role : userRoles) {
            log.info("All user roles: " + role);
        }
    }

    /**
     * Get user role test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getUserRoleTest() throws Exception {
        UserRole userRole = userRoleDao.getUserRole(1);
        log.info("The userRole: " + userRole);
        assertNotNull("UserRole with id of value 1 wasn't found", userRole);
    }

    /**
     * Add user role test.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddUserRole() throws Exception {
        // Create a user, add it to the database
        User user = new User("Liz", "Pelton", "password", "lpelton@wifeMail.com", "608-111-2222", "lpelton");
        UserDao userDao = new UserDao();
        userDao.addUser(user);
        log.info("Added the user to user dao: " + user);

        // Create a userRole, add it to the database
        UserRole userRole = new UserRole(7, user, "registered-user");
        userRoleDao.addUserRole(userRole);
        log.info("Added the userRole to userRole dao: " + userRole);

        // get the added user role
        UserRole newUserRole = userRoleDao.getUserRole(7);
        assertTrue(userRole.equals(newUserRole));
    }

    /**
     * Delete user role test.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDeleteUserRole() throws Exception {

        UserRole userRole = userRoleDao.getUserRole(7);
        assertTrue(userRole != null);
        userRoleDao.deleteUserRole(7);
        userRole = userRoleDao.getUserRole(7);
        assertTrue(userRole == null);

    }

    /**
     * Update user role test.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateUserRoleTest() throws Exception {
        UserRole userRole = userRoleDao.getUserRole(3);
        assertTrue(userRole != null);
        userRole.setRoleName("fakeRoleName");
        userRoleDao.updateUserRole(userRole);
        assertEquals("The user role name wasn't successfully updated.", "fakeRoleName", userRole.getRoleName());
    }
}