package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;


/**
 * The User dao.
 *
 * @author ssoper 10/3/2017.
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
            log.error("Error in getAllUsers method: ", e);
        } finally {
            session.close();
        }
        return users;
    }

    /**
     * retrieve a user given their id
     *
     * READ step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(int id) {
        User user = null;
        Session databaseSession = null;
        Transaction transaction = null;

        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            user = (User) databaseSession.get(User.class, id);
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in getUser method with user id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return user;
    }

    /**
     * add a user
     *
     * CREATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param user the user
     * @return the userId of the inserted record
     */
    public int addUser(User user) {
        Session databaseSession = null;
        Transaction transaction = null;
        int userId = 0;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            userId = (int) databaseSession.save(user);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in addUser method with user id: " + userId + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return userId;
    }

    /**
     * delete a user by id
     *
     * DELETE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the user's id
     */
    public void deleteUser(int id) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            User user = (User) databaseSession.get(User.class, id);
            databaseSession.delete(user);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in deleteUser method with user id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }

    /**
     * Update the user
     *
     * UPDATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param user the user
     */
    public void updateUser(User user) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            databaseSession.saveOrUpdate(user);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in updateUser method with user: " + user + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }
}
