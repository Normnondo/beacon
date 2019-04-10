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
@Table(name = "beacon_user_test") // Fix!
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
    private int zipCode;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "email")
    private String email;

 //   @OneToMany(mappedBy = "beaconUsers", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  //  private Set<BeaconGames> games = new HashSet<>();



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
     */
    public BeaconUsers(String firstName, String lastName, int zipCode, int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets phone number if Beacon users want to connect this way.
     *
     * @return the phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets email if Beacon users want to connect this way.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets games.
     *
     * @return the games
     */
  //  public Set<BeaconGames> getGames() {
  //      return games;
  //  }

    /**
     * Sets games.
     *
     * @param games the games
     */
 //   public void setGames(Set<BeaconGames> games) {
 //      this.games = games;
 //   }

 //   public void addGame(BeaconGames game) {
  //      games.add(game);
  //      game.setBeaconUsers(this);
  //  }

 //   public void removeGame(BeaconGames game) {
  //      games.remove(game);
  //      game.setBeaconUsers(null);
  //  }

    @Override
    public String toString() {

        return "BeaconUser{" +
                "id= '" + id + '\'' +
                "firstName= '" + firstName + '\'' +
                "lastName= '" + lastName + '\'' +
                "zipCode= '" + zipCode + '\'' +
                "phoneNumber= '" + phoneNumber + '\'' +
                "email= '" + email + '\'' +
                "}";
    }


}
