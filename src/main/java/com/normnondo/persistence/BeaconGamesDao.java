package com.normnondo.persistence;

import com.normnondo.entity.BeaconUsers;
import com.normnondo.entity.BeaconGames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class BeaconGamesDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users.
     *
     * @return all the users
     */
    public List<BeaconGames> getAllGames() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder =  session.getCriteriaBuilder();
        CriteriaQuery<BeaconGames> query = builder.createQuery(BeaconGames.class);
        Root<BeaconGames> root = query.from(BeaconGames.class);
        List<BeaconGames> games = session.createQuery(query).getResultList();
        session.close();
        return games;
    }

    public List<BeaconGames> getGamesByType(String gameType) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconGames> query = builder.createQuery(BeaconGames.class);
        Root<BeaconGames> root = query.from(BeaconGames.class);
        Expression<String> propertyPath = root.get("gameType");
        query.where(builder.like(propertyPath, "%" + gameType + "%"));
        List<BeaconGames> games = session.createQuery(query).getResultList();
        session.close();
        return games;
    }

    public List<BeaconGames> getGamesByStyle(String gameStyle) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconGames> query = builder.createQuery(BeaconGames.class);
        Root<BeaconGames> root = query.from(BeaconGames.class);
        Expression<String> propertyPath = root.get("gameStyle");
        query.where(builder.like(propertyPath, "%" + gameStyle + "%"));
        List<BeaconGames> games = session.createQuery(query).getResultList();
        session.close();
        return games;
    }

    public List<BeaconGames> getGamesByPoints(int points) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconGames> query = builder.createQuery(BeaconGames.class);
        Root<BeaconGames> root = query.from(BeaconGames.class);
        Expression<String> propertyPath = root.get("points");
        query.where(builder.equal(propertyPath, points));
        List<BeaconGames> games = session.createQuery(query).getResultList();
        session.close();
        return games;
    }

    public List<BeaconGames> getGamesByArmy(String army) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconGames> query = builder.createQuery(BeaconGames.class);
        Root<BeaconGames> root = query.from(BeaconGames.class);
        Expression<String> propertyPath = root.get("army");
        query.where(builder.equal(propertyPath, army));
        List<BeaconGames> games = session.createQuery(query).getResultList();
        session.close();
        return games;
    }

    public List<BeaconGames> getGamesByLocation(String location) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BeaconGames> query = builder.createQuery(BeaconGames.class);
        Root<BeaconGames> root = query.from(BeaconGames.class);
        Expression<String> propertyPath = root.get("location");
        query.where(builder.like(propertyPath, "%" + location + "%"));
        List<BeaconGames> games = session.createQuery(query).getResultList();
        session.close();
        return games;
    }

    public BeaconGames getGameById(int id) {

        Session session = sessionFactory.openSession();
        logger.debug("Searching for game by ID: " + id);

        BeaconGames game = session.get(BeaconGames.class, id);
        session.close();
        return game;
    }

    public void saveOrUpdate(BeaconGames game) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(game);
        transaction.commit();
        session.close();
    }

    public int insert(BeaconGames game) {
        int id = 0;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(game);
        transaction.commit();
        session.close();
        return id;
    }

    public void delete(BeaconGames game) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(game);
        transaction.commit();
        session.close();
    }

  /**  public List<BeaconUsers> getByPropertyEqual(String propertyName, String value) {

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
    }*/
}
