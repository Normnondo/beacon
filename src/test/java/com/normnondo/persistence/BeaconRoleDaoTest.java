package com.normnondo.persistence;

import com.normnondo.entity.*;
import com.normnondo.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeaconRoleDaoTest {
    // mkyong for many to many demo

    BeaconDao beaconDao;

    @BeforeEach
    void setUp() {
        beaconDao = new BeaconDao(BeaconRole.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllUsersSuccess() {
        List<BeaconRole> users = (List<BeaconRole>)beaconDao.getAll();
        assertEquals(6, users.size());
    }

    @Test
    void getUsersByEmailSuccess() {
        List<BeaconRole> users = beaconDao.getByEmail("jtest@gmail.com");
        assertEquals(1, users.size());
    }

    @Test
    void getUserByIdSuccess() {
        BeaconRole users = (BeaconRole)beaconDao.getById(2);
        assertEquals("bmadison@gmail.com", users.getEmail());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newRoleName = "admin";
        BeaconRole userToUpdate = (BeaconRole)beaconDao.getById(4);
        userToUpdate.setRoleName(newRoleName);
        beaconDao.saveOrUpdate(userToUpdate);
        BeaconRole retrievedUser = (BeaconRole)beaconDao.getById(4);
        assertEquals(newRoleName, retrievedUser.getRoleName());
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<BeaconRole> beaconRole = beaconDao.getByPropertyEqual("email", "jtest@gmail.com");
        assertEquals(1, beaconRole.size());
        assertEquals(1, beaconRole.get(0).getId());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<BeaconRole> beaconRole = beaconDao.getByPropertyLike("email", "t");
        assertEquals(5, beaconRole.size());

    }

}