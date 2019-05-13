package com.normnondo.persistence;

import com.normnondo.entity.*;
import com.normnondo.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeaconUsersDaoTest {
    // mkyong for many to many demo

    BeaconDao beaconDao;
    BeaconDao beaconGamesDao;

    @BeforeEach
    void setUp() {
        beaconDao = new BeaconDao(BeaconUsers.class);
        beaconGamesDao = new BeaconDao(BeaconGames.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllUsersSuccess() {
        List<BeaconUsers> users = (List<BeaconUsers>)beaconDao.getAll();
        assertEquals(6, users.size());
    }

    @Test
    void getUsersByLastNameSuccess() {
        List<BeaconUsers> users = beaconDao.getByLastName("Test");
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByFirstNameSuccess() {
        List<BeaconUsers> users = beaconDao.getByFirstName("Freddie");
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByZipCodeSuccess() {
        List<BeaconUsers> users = beaconDao.getByZipCode("53718");
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByPhoneNumberSuccess() {
        List<BeaconUsers> users = beaconDao.getByPhoneNumber("5551234");
        assertEquals(1, users.size());
    }

    @Test
    void getUsersByEmailSuccess() {
        List<BeaconUsers> users = beaconDao.getByEmail("jtest@gmail.com");
        assertEquals(1, users.size());
    }

    @Test
    void getUserByIdSuccess() {
        BeaconUsers users = (BeaconUsers)beaconDao.getById(2);
        assertEquals("Billy", users.getFirstName());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newLastName = "Williams";
        BeaconUsers userToUpdate = (BeaconUsers)beaconDao.getById(4);
        userToUpdate.setLastName(newLastName);
        beaconDao.saveOrUpdate(userToUpdate);
        BeaconUsers retrievedUser = (BeaconUsers)beaconDao.getById(4);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    @Test
    void insertSuccess() {
       // int id = 0;

        BeaconUsers beaconUsers = new BeaconUsers("Fred","Flintstone","53588","5559876","fflint@yahoo.com", "taco");
        int id = beaconDao.insert(beaconUsers);
        assertNotEquals(0,id);
        BeaconUsers insertedBeaconUser = (BeaconUsers)beaconDao.getById(id);
        assertEquals("Fred", insertedBeaconUser.getFirstName());
    }

    @Test
    void deleteSuccess() {
        beaconDao.delete(beaconDao.getById(3));
        assertNull(beaconDao.getById(3));

    }

    @Test
    void deleteCompleteSuccess() {
        beaconDao.delete(beaconDao.getById(3));
        assertNull(beaconGamesDao.getById(1));
        assertNull(beaconDao.getById(3));

    }

    @Test
    void getByPropertyEqualSuccess() {
        List<BeaconUsers> beaconUsers = beaconDao.getByPropertyEqual("lastName", "Mercury");
        assertEquals(1, beaconUsers.size());
        assertEquals(3, beaconUsers.get(0).getId());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<BeaconUsers> beaconUsers = beaconDao.getByPropertyLike("lastName", "m");
        assertEquals(4, beaconUsers.size());

    }

}