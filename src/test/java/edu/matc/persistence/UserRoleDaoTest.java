package edu.matc.persistence;

import edu.matc.entity.UserRole;
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
public class UserRoleDaoTest {

    UserRoleDao dao;
    int numberOfUserRolesInDatabase;

    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        dao = new UserRoleDao();
        numberOfUserRolesInDatabase = dao.getAllUserRoles().size();
    }

    @Test
    public void getAllUserRolesTest() throws Exception {
        List<UserRole> userRoles = dao.getAllUserRoles();
        assertTrue(userRoles.size() > 0);
    }

    @Test
    public void getUserRoleTest() throws Exception {
        UserRole userRole = dao.getUserRole(1);
        assertNotNull("UserRole with id of value 1 wasn't found", userRole);
        assertEquals("admin was not returned", "admin", userRole.getUserRoleName());
    }

    @Test
    public void deleteUserRoleTest() throws Exception {

        // TODO Should probably add a temporary userRole before deleting so I can run this more than once
        UserRole userRole = dao.getUserRole(6);
        assertTrue(userRole != null);
        dao.deleteUserRole(6);
        userRole = dao.getUserRole(6);
        assertTrue(userRole == null);
    }

    @Test
    public void addUserRoleTest() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setUserRoleId(2);
        userRole.setUserRoleName("testUserRoleName");
        userRole.setRoleName("testRoleName");

        int newUserRole = dao.addUserRole(userRole);
        UserRole actualUserRole = dao.getUserRole(newUserRole);
        assertNotNull("New test userRole not inserted.", actualUserRole);
        assertEquals("New test userRole wasn't added in the right spot", "testUserRoleName",actualUserRole.getUserRoleName());
        assertEquals("Number of rows didn't increase.", numberOfUserRolesInDatabase + 1, dao.getAllUserRoles().size());
    }

    @Test
    public void updateUserRoleTest() throws Exception {
        UserRole userRole = dao.getUserRole(2);
        assertTrue(userRole != null);
        userRole.setUserRoleName("Foo_bar");
        dao.updateUserRole(userRole);
        userRole = dao.getUserRole(2);
        assertTrue(userRole != null);
        assertEquals("The usre role name wasn't successfully updated.", "Foo_bar", userRole.getUserRoleName());
    }

    //TODO use .equals() on each entity for easy testing - insert a userRole to the db and read it back
}