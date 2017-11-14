package edu.matc.persistence;

import edu.matc.entity.Chore;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;


/**
 * The Chore dao.
 *
 * @author ssoper 10/31/2017.
 */
public class ChoreDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all chores
     *
     * @return All chores
     */
    public List<Chore> getAllChores() {
        List<Chore> chores = new ArrayList<Chore>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            chores = session.createCriteria(Chore.class).list();
        } catch (HibernateException he) {
            log.error("Error in getAllChores method: ", he);
        } finally {
            session.close();
        }
        return chores;
    }

    /**
     * retrieve a chore given its id
     *
     * READ step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the chore's id
     * @return chore chore
     */
    public Chore getChore(int id) {
        Chore chore = null;
        Session databaseSession = null;
        Transaction transaction = null;

        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            chore = (Chore) databaseSession.get(Chore.class, id);
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in getChore method with chore id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return chore;
    }

    /**
     * add a chore
     *
     * CREATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param chore the chore
     * @return the choreId of the inserted record
     */
    public int addChore(Chore chore) {
        Session databaseSession = null;
        Transaction transaction = null;
        int choreId = 0;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            choreId = (int) databaseSession.save(chore);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in addChore method with chore id: " + choreId + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return choreId;
    }

    /**
     * delete a chore by id
     *
     * DELETE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the chore's id
     */
    public void deleteChore(int id) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            Chore chore = (Chore) databaseSession.get(Chore.class, id);
            databaseSession.delete(chore);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in deleteChore method with chore id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }

    /**
     * Update the chore
     *
     * UPDATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param chore the chore
     */
    public void updateChore(Chore chore) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            databaseSession.saveOrUpdate(chore);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in updateChore method with chore: " + chore + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }
}
