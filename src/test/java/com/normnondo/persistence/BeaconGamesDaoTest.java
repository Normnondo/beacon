package com.normnondo.persistence;

import com.normnondo.entity.*;
import com.normnondo.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeaconGamesDaoTest {
/*
    BeaconGamesDao dao;
    BeaconUsersDao userDao;


    @BeforeEach
    void setUp() {
        dao = new BeaconGamesDao();
        userDao = new BeaconUsersDao();


        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllGamesSuccess() {
        List<BeaconGames> games = dao.getAllGames();
        assertEquals(6, games.size());
    }

    @Test
    void getGamesByTypeSuccess() {
        List<BeaconGames> games = dao.getGamesByType("40k");
        assertEquals(6, games.size());
    }

    @Test
    void getGamesByStyleSuccess() {
        List<BeaconGames> games = dao.getGamesByStyle("HRD");
        assertEquals(2, games.size());
    }

    @Test
    void getGamesByPointsSuccess() {
        List<BeaconGames> games = dao.getGamesByPoints(2000);
        assertEquals(4, games.size());
    }

    @Test
    void getGamesByArmySuccess() {
        List<BeaconGames> games = dao.getGamesByArmy("ORK");
        assertEquals(2, games.size());
    }

    @Test
    void getGamesByLocationSuccess() {
        List<BeaconGames> games = dao.getGamesByLocation("PEG");
        assertEquals(2, games.size());
    }

    @Test
    void getGameByIdSuccess() {
        BeaconGames games = dao.getGameById(2);
        assertEquals("ORK", games.getArmy());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newArmy = "SPM";
        BeaconGames gameToUpdate = dao.getGameById(4);
        gameToUpdate.setArmy(newArmy);
        dao.saveOrUpdate(gameToUpdate);
        BeaconGames retrievedGame = dao.getGameById(4);
        assertEquals(newArmy, retrievedGame.getArmy());
    }

    @Test
    void insertSuccess() {
        BeaconUsers beaconUsers = new BeaconUsers("Fred","Flintstone",53588,5559876,"fflint@yahoo.com");
        int userid = userDao.insert(beaconUsers);
        BeaconGames beaconGames = new BeaconGames("40k", "HRD", 2000, "SPM", "MST", beaconUsers);
        beaconUsers.addGame(beaconGames);
        int id = dao.insert(beaconGames);
        assertNotEquals(0,userid);
        BeaconGames insertedBeaconGame = dao.getGameById(id);
        assertEquals(2000, insertedBeaconGame.getPoints());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getGameById(3));
        assertNull(dao.getGameById(3));

    }

   /** @Test
    void getByPropertyEqualSuccess() {
        List<BeaconUsers> beaconUsers = dao.getByPropertyEqual("lastName", "Mercury");
        assertEquals(1, beaconUsers.size());
        assertEquals(3, beaconUsers.get(0).getId());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<BeaconUsers> beaconUsers = dao.getByPropertyLike("lastName", "m");
        assertEquals(4, beaconUsers.size());

    }*/


}