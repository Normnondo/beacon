package com.normnondo.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 * @param <T> the type parameter
 */
public class BeaconDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type, for example, User.
     */
    public BeaconDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities
     *
     * @return the all entities
     */
    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type); //?? Why is root never used here?
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;

    }

    /**
     * Gets by type.
     *
     * @param gameType the game type
     * @return the by type
     */
    public List<T> getByType(String gameType) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("gameType");
        query.where(builder.like(propertyPath, "%" + gameType + "%"));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by style.
     *
     * @param gameStyle the game style
     * @return the by style
     */
    public List<T> getByStyle(String gameStyle) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("gameStyle");
        query.where(builder.like(propertyPath, "%" + gameStyle + "%"));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by points.
     *
     * @param points the points
     * @return the by points
     */
    public List<T> getByPoints(String points) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("points");
        query.where(builder.equal(propertyPath, points));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by army.
     *
     * @param army the army
     * @return the by army
     */
    public List<T> getByArmy(String army) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("army");
        query.where(builder.equal(propertyPath, army));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by location.
     *
     * @param location the location
     * @return the by location
     */
    public List<T> getByLocation(String location) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("location");
        query.where(builder.like(propertyPath, "%" + location + "%"));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets an entity by id
     *
     * @param <T> the type parameter
     * @param id  entity id to search by
     * @return entity by id
     */
    public <T> T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Gets by last name.
     *
     * @param lastName the last name
     * @return the by last name
     */
    public List<T> getByLastName(String lastName) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by first name.
     *
     * @param firstName the first name
     * @return the by first name
     */
    public List<T> getByFirstName(String firstName) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("firstName");
        query.where(builder.like(propertyPath, "%" + firstName + "%"));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by zip code.
     *
     * @param zipCode the zip code
     * @return the by zip code
     */
    public List<T> getByZipCode(String zipCode) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("zipCode");
        query.where(builder.equal(propertyPath, zipCode));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by phone number.
     *
     * @param phoneNumber the phone number
     * @return the by phone number
     */
    public List<T> getByPhoneNumber(String phoneNumber) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("phoneNumber");
        query.where(builder.equal(propertyPath, phoneNumber));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by email.
     *
     * @param email the email
     * @return the by email
     */
    public List<T> getByEmail(String email) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("email");
        query.where(builder.like(propertyPath, "%" + email + "%"));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by role name.
     *
     * @param roleName the role name
     * @return the by role name
     */
    public List<T> getByRoleName(String roleName) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("roleName");
        query.where(builder.like(propertyPath, "%" + roleName + "%"));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Save or update.
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Insert int.
     *
     * @param entity the entity
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Deletes the entity.
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Gets by property equal.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {

        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entity = session.createQuery(query).getResultList();
        session.close();
        return entity;
    }

    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}

