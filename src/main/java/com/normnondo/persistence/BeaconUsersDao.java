package com.normnondo.persistence;

import com.normnondo.entity.BeaconUsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class BeaconUsersDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users.
     *
     * @return all the users
     */
    public List<BeaconUsers> getAllUsers() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder =  session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<BeaconUsers> getUsersByLastName(String lastName) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<BeaconUsers> getUsersByFirstName(String firstName) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        Expression<String> propertyPath = root.get("firstName");
        query.where(builder.like(propertyPath, "%" + firstName + "%"));
        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<BeaconUsers> getUsersByZipCode(int zipCode) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        Expression<String> propertyPath = root.get("zipCode");
        query.where(builder.like(propertyPath, "%" + zipCode + "%"));
        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<BeaconUsers> getUsersByPhoneNumber(int phoneNumber) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        Expression<String> propertyPath = root.get("phoneNumber");
        query.where(builder.like(propertyPath, "%" + phoneNumber + "%"));
        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<BeaconUsers> getUsersByEmail(String email) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        Expression<String> propertyPath = root.get("email");
        query.where(builder.like(propertyPath, "%" + email + "%"));
        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<BeaconUsers> getUsersById(int id) {

        Session session = sessionFactory.openSession();

        BeaconUsers user = session.get(BeaconUsers.class, id);
        session.close();
        return user;
    }

    public void saveOrUpdate(BeaconUsers user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public int insert(BeaconUsers user) {
        int id = 0;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    public void delete(BeaconUsers user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<BeaconUsers> getByPropertyEqual(String propertyName, String value) {

        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public List<BeaconUsers> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconUsers> query = builder.createQuery(BeaconUsers.class);
        Root<BeaconUsers> root = query.from(BeaconUsers.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<BeaconUsers> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }
}
