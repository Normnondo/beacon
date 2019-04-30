package com.normnondo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Beacon games.
 */
@Entity(name = "BeaconGames")
@Table(name = "games_test")
public class BeaconGames {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "game_type")
    private String gameType;

    @Column(name = "game_style")
    private String gameStyle;

    @Column(name = "points")
    private String points;

    @Column(name = "army")
    private String army;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "beaconUsers_id", nullable = false)
    private BeaconUsers beaconUsers;

    /**
     * Instantiates a new Beacon games.
     */
    public BeaconGames() {
    }


    /**
     * Instantiates a new Beacon games.
     *
     * @param gameType  the game type
     * @param gameStyle the game style
     * @param points    the points
     * @param army      the army
     * @param location  the location
     * @param beaconUsers      the user id
     */
    public BeaconGames(String gameType, String gameStyle, String points, String army, String location, BeaconUsers beaconUsers) {
        this.gameType = gameType;
        this.gameStyle = gameStyle;
        this.points = points;
        this.army = army;
        this.location = location;
        this.beaconUsers = beaconUsers;
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
     * Gets game type.
     *
     * @return the game type
     */
    public String getGameType() {
        return gameType;
    }

    /**
     * Sets game type.
     *
     * @param gameType the game type
     */
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    /**
     * Gets game style.
     *
     * @return the game style
     */
    public String getGameStyle() {
        return gameStyle;
    }

    /**
     * Sets game style.
     *
     * @param gameStyle the game style
     */
    public void setGameStyle(String gameStyle) {
        this.gameStyle = gameStyle;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public String getPoints() {
        return points;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(String points) {
        this.points = points;
    }

    /**
     * Gets army.
     *
     * @return the army
     */
    public String getArmy() {
        return army;
    }

    /**
     * Sets army.
     *
     * @param army the army
     */
    public void setArmy(String army) {
        this.army = army;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public BeaconUsers getBeaconUsers() {
        return beaconUsers;
    }

    /**
     * Sets user id.
     *
     * @param beaconUsers the user
     */
    public void setBeaconUsers(BeaconUsers beaconUsers) {
        this.beaconUsers = beaconUsers;
    }

    @Override
    public String toString() {
        return "BeaconGames{" +
                "id=" + id +
                ", gameType='" + gameType + '\'' +
                ", gameStyle='" + gameStyle + '\'' +
                ", points=" + points +
                ", army='" + army + '\'' +
                ", location='" + location + '\'' +
                ", userid='" + beaconUsers + '\'' +
                '}';
    }


}
