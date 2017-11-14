package edu.matc.persistence;

import edu.matc.entity.House;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;


/**
 * The House dao.
 *
 * @author ssoper 10/31/2017.
 */
public class HouseDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all houses
     *
     * @return All houses
     */
    public List<House> getAllHouses() {
        List<House> houses = new ArrayList<House>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            houses = session.createCriteria(House.class).list();
        } catch (HibernateException he) {
            log.error("Error in getAllHouses method: ", he);
        } finally {
            session.close();
        }
        return houses;
    }

    /**
     * retrieve a house given its id
     *
     * READ step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the house's id
     * @return house
     */
    public House getHouse(int id) {
        House house = null;
        Session databaseSession = null;
        Transaction transaction = null;

        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            house = (House) databaseSession.get(House.class, id);
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in getHouse method with house id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return house;
    }

    /**
     * add a house
     *
     * CREATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param house the house
     * @return the houseId of the inserted record
     */
    public int addHouse(House house) {
        Session databaseSession = null;
        Transaction transaction = null;
        int houseId = 0;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            houseId = (int) databaseSession.save(house);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in addHouse method with house id: " + houseId + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
        return houseId;
    }

    /**
     * delete a house by id
     *
     * DELETE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param id the house's id
     */
    public void deleteHouse(int id) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            House house = (House) databaseSession.get(House.class, id);
            databaseSession.delete(house);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in deleteHouse method with house id: " + id + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }

    /**
     * Update the house
     *
     * UPDATE step in CRUD (CREATE READ UPDATE DELETE)
     *
     * @param house the house
     */
    public void updateHouse(House house) {
        Session databaseSession = null;
        Transaction transaction = null;
        try {
            databaseSession = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = databaseSession.beginTransaction();
            databaseSession.saveOrUpdate(house);
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
                log.error("Error in updateHouse method with house: " + house + ", ", he);
            }
        } finally {
            databaseSession.close();
        }
    }
}
