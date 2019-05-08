package com.normnondo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

   // @OneToMany(mappedBy = "beaconUsers", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   // private Set<BeaconUsers> beaconUsers = new HashSet<>();



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
    public BeaconRole(String roleName, String email) {
        this.roleName = roleName;
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

    @Override
    public String toString() {

        return "BeaconRole{" +
                "id= '" + id + '\'' +
                "roleName= '" + roleName + '\'' +
                "email= '" + email + '\'' +
                "}";
    }


}
