package com.normnondo.persistence;

import com.normnondo.entity.BeaconUsers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeaconUsersDaoTest {

    BeaconUsersDao dao;

    @BeforeEach
    void setUp() {
        dao = new BeaconUsersDao();
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
        List<BeaconUsers> users = dao.getUsersByFirstName("Billy");
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
    void getUsersByIdSuccess() {
        List<BeaconUsers> users = dao.getUsersById(2);
        assertEquals("Billy", users.getFirstName());
    }

    @Test
    void saveOrUpdateSuccess() {
    }

    @Test
    void insertSuccess() {
    }

    @Test
    void deleteSuccess() {
    }

    @Test
    void getByPropertyEqualSuccess() {
    }

    @Test
    void getByPropertyLikeSuccess() {
    }
}