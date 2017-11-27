package edu.matc.persistence;

import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;


/**
 * The User role dao.
 *
 * @author ssoper 11/2/2017.
 */
public class UserRoleDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all userRoles
     *
     * @return All userRoles
     */
    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new ArrayList<UserRole>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            userRoles = session.createCriteria(UserRole.class).list();
        } catch (HibernateException he) {
            log.error("Error in getAllUserRoles method: ", he);
        } finally {
            session.close();
        }
        return userRoles;
    }

    /**
     * retrieve a userRole given their id
     *
     * READ step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the userRole's id
     * @return user role
     */
    public UserRole getUserRole(int id) {
        UserRole userRole = null;
        Session databaseSession = null;
        Transaction transaction = null;

        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            userRole = (UserRole) databaseSession.get(UserRole.class, id);
        } catch (Exception he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in getUserRole method with userRole id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return userRole;
    }

    /**
     * add a userRole
     *
     * CREATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param userRole the user role
     * @return the userRoleId of the inserted record
     */
    public int addUserRole(UserRole userRole) {
        Session databaseSession = null;
        Transaction transaction = null;
        int userRoleId = 0;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            userRoleId = (int) databaseSession.save(userRole);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in addUserRole method with userRole id: " + userRoleId + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return userRoleId;
    }

    /**
     * delete a userRole by id
     *
     * DELETE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the userRole's id
     */
    public void deleteUserRole(int id) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            UserRole userRole = (UserRole) databaseSession.get(UserRole.class, id);
            databaseSession.delete(userRole);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in deleteUserRole method with userRole id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }

    /**
     * Update the userRole
     * 
     * UPDATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param userRole the user role
     */
    public void updateUserRole(UserRole userRole) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            databaseSession.saveOrUpdate(userRole);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in updateUserRole method with userRole: " + userRole + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }
}
