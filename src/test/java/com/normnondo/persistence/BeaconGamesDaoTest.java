package com.normnondo.persistence;

import com.normnondo.entity.*;
import com.normnondo.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeaconGamesDaoTest {

    BeaconDao beaconDao;


    @BeforeEach
    void setUp() {
        beaconDao = new BeaconDao(BeaconGames.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllGamesSuccess() {
        List<BeaconGames> games = (List<BeaconGames>)beaconDao.getAll();
        assertEquals(6, games.size());
    }

    @Test
    void getGamesByTypeSuccess() {
        List<BeaconGames> games = beaconDao.getByType("40k");
        assertEquals(6, games.size());
    }

    @Test
    void getGamesByStyleSuccess() {
        List<BeaconGames> games = beaconDao.getByStyle("Narrative");
        assertEquals(2, games.size());
    }

    @Test
    void getGamesByPointsSuccess() {
        List<BeaconGames> games = beaconDao.getByPoints("2000");
        assertEquals(4, games.size());
    }

    @Test
    void getGamesByArmySuccess() {
        List<BeaconGames> games = beaconDao.getByArmy("Orks");
        assertEquals(2, games.size());
    }

    @Test
    void getGamesByLocationSuccess() {
        List<BeaconGames> games = beaconDao.getByLocation("Pegasus");
        assertEquals(2, games.size());
    }

    @Test
    void getGameByIdSuccess() {
        BeaconGames games = (BeaconGames)beaconDao.getById(2);
        assertEquals("Orks", games.getArmy());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newArmy = "Space Marines";
        BeaconGames gameToUpdate = (BeaconGames)beaconDao.getById(4);
        gameToUpdate.setArmy(newArmy);
        beaconDao.saveOrUpdate(gameToUpdate);
        BeaconGames retrievedGame = (BeaconGames)beaconDao.getById(4);
        assertEquals(newArmy, retrievedGame.getArmy());
    }
/*
    @Test
    void insertSuccess() {
        BeaconUsers beaconUsers = new BeaconUsers("Fred","Flintstone","53588","5559876","fflint@yahoo.com", "taco");
        int userid = beaconDao.insert(beaconUsers);
        BeaconGames beaconGames = new BeaconGames("40k", "ITC Style", "2000", "Space Marines", "Misty Mountain", "userid");
        int id = beaconDao.insert(beaconGames);
        assertNotEquals(0,userid);
        BeaconGames insertedBeaconGame = (BeaconGames)beaconDao.getById(id);
        assertEquals("2000", insertedBeaconGame.getPoints());
    }
*/
    @Test
    void deleteSuccess() {
        beaconDao.delete(beaconDao.getById(3));
        assertNull(beaconDao.getById(3));

    }

    @Test
    void getByPropertyEqualSuccess() {
        List<BeaconGames> beaconGames = beaconDao.getByPropertyEqual("army", "Eldar");
        assertEquals(1, beaconGames.size());
        assertEquals(4, beaconGames.get(0).getId());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<BeaconGames> beaconGames = beaconDao.getByPropertyLike("location", "M");
        assertEquals(2, beaconGames.size());

    }


}