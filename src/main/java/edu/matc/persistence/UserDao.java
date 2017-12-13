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
     * retrieve a user given their userName
     *
     * READ step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param userName the user's userName
     * @return user user
     */
    public User getUser(String userName) {
        User user = null;
        Session databaseSession = null;
        Transaction transaction = null;

        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            user = (User) databaseSession.get(User.class, userName);
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in getUser method with user name: " + userName + ", ", he);
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
    public String addUser(User user) {
        Session databaseSession = null;
        Transaction transaction = null;
        String userName = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            userName = (String) databaseSession.save(user);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in addUser method with user name: " + userName + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return userName;
    }

    /**
     * delete a user by userName
     * <p>
     * DELETE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param userName the user's user name
     */
    public void deleteUser(String userName) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            User user = (User) databaseSession.get(User.class, userName);
            databaseSession.delete(user);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in deleteUser method with userName: " + userName + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }

    /**
     * Update the user
     * <p>
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
