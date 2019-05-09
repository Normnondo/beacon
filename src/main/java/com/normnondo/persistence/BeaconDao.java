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
     * @param id entity id to search by
     * @return entity
     */
    public <T> T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

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

    public void saveOrUpdate(T entity) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

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

