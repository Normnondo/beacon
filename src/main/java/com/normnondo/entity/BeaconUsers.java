package com.normnondo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Beacon users.
 *
 * @author normnondo
 */
@Entity(name = "BeaconUsers")
//@Table(name = "beacon_user_test")
@Table(name = "beacon_users")
public class BeaconUsers {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "beaconUsers", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<BeaconGames> beaconGames = new HashSet<>();

    /**
     * Instantiates a new Beacon users.
     */
    public BeaconUsers() {
    }

    /**
     * Instantiates a new Beacon users.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param zipCode     the zip code
     * @param phoneNumber the phone number
     * @param email       the email
     * @param password    the password
     */
    public BeaconUsers(String firstName, String lastName, String zipCode, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets zip code for matching with other Beacon users.
     *
     * @return the zip code
     */
    public String getZipCode() { return zipCode; }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets phone number if Beacon users want to connect this way.
     *
     * @return the phone number
     */
    public String getPhoneNumber() { return phoneNumber; }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    /**
     * Gets email if Beacon users want to connect this way.
     *
     * @return the email
     */
    public String getEmail() { return email; }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Gets password if Beacon users want to connect this way.
     *
     * @return the password
     */
    public String getPassword() { return password; }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {

        return "BeaconUser{" +
                "id= '" + id + '\'' +
                "firstName= '" + firstName + '\'' +
                "lastName= '" + lastName + '\'' +
                "zipCode= '" + zipCode + '\'' +
                "phoneNumber= '" + phoneNumber + '\'' +
                "email= '" + email + '\'' +
                "password= '********' " +
                "}";
    }

}
