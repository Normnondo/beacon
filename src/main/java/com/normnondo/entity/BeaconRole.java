package com.normnondo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Beacon role.
 *
 * @author normnondo
 */
@Entity(name = "BeaconRole")
@Table(name = "role")
public class BeaconRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "beaconUsers_id", nullable = false)
    private BeaconUsers beaconUsers;

    /**
     * Instantiates a new Beacon role.
     */
    public BeaconRole() {
    }

    /**
     * Instantiates a new Beacon role.
     *
     * @param roleName    the role name
     * @param email       the users email
     */
    public BeaconRole(String roleName, String email, BeaconUsers beaconUsers) {
        this.roleName = roleName;
        this.email = email;
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
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

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

        return "BeaconRole{" +
                "id= '" + id + '\'' +
                "roleName= '" + roleName + '\'' +
                "email= '" + email + '\'' +
                "userId= '" + beaconUsers + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeaconRole role = (BeaconRole) o;
        return id == role.id &&
                Objects.equals(email, role.email) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(beaconUsers.getId(), role.beaconUsers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleName, email, beaconUsers);
    }

}
