package com.normnondo.persistence;

import com.normnondo.entity.*;
import com.normnondo.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeaconUsersDaoTest {
  /*  // mkyong for many to many demo

    BeaconUsersDao dao;
  //  BeaconGamesDao gamesDao;

    @BeforeEach
    void setUp() {
        dao = new BeaconUsersDao();
       // gamesDao = new BeaconGamesDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllUsersSuccess() {
        List<BeaconUsers> users = dao.getAllUsers();
        assertEquals(6, users.size());
    }

    @Test
    void getUsersByLastNameSuccess() {
        List<BeaconUsers> users = dao.getUsersByLastName("Test");
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByFirstNameSuccess() {
        List<BeaconUsers> users = dao.getUsersByFirstName("Freddie");
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByZipCodeSuccess() {
        List<BeaconUsers> users = dao.getUsersByZipCode(53718);
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByPhoneNumberSuccess() {
        List<BeaconUsers> users = dao.getUsersByPhoneNumber(5551234);
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByEmailSuccess() {
        List<BeaconUsers> users = dao.getUsersByEmail("jtest@gmail.com");
        assertEquals(1, users.size());
    }

    @Test
    void getUserByIdSuccess() {
        BeaconUsers users = dao.getUserById(2);
        assertEquals("Billy", users.getFirstName());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newLastName = "Williams";
        BeaconUsers userToUpdate = dao.getUserById(4);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        BeaconUsers retrievedUser = dao.getUserById(4);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    @Test
    void insertSuccess() {

        BeaconUsers beaconUsers = new BeaconUsers("Fred","Flintstone",53588,5559876,"fflint@yahoo.com");
        int id = dao.insert(beaconUsers);
        assertNotEquals(0,id);
        BeaconUsers insertedBeaconUser = dao.getUserById(id);
        assertEquals("Fred", insertedBeaconUser.getFirstName());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getUserById(3));
        assertNull(dao.getUserById(3));

    }

    @Test
    void getByPropertyEqualSuccess() {
        List<BeaconUsers> beaconUsers = dao.getByPropertyEqual("lastName", "Mercury");
        assertEquals(1, beaconUsers.size());
        assertEquals(3, beaconUsers.get(0).getId());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<BeaconUsers> beaconUsers = dao.getByPropertyLike("lastName", "m");
        assertEquals(4, beaconUsers.size());

    }

    @Test
    void insertGamesSuccess() {
        BeaconUsers beaconUsers = new BeaconUsers("Fred","Flintstone",53588,5559876,"fflint@yahoo.com");
        BeaconGames game = new BeaconGames("40k", "HRD", 2000, "SPM", "MST", beaconUsers);
        beaconUsers.addGame(game);
        int id = dao.insert(beaconUsers);
        assertNotEquals(0,id);
        BeaconUsers insertedBeaconUser = dao.getUserById(id);
        assertEquals("Fred", insertedBeaconUser.getFirstName());
        assertEquals(1, insertedBeaconUser.getGames().size());
    }*/
}