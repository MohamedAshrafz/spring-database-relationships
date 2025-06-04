package io.spring.spring_database_relationships.onetoone.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // To make The one-to-one unidirectional relation
    @OneToOne(cascade = CascadeType.ALL)
    // Name the foreign key column profile_id that's mapped from id in the PlayerProfile entity
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
//    @JsonProperty("profile") // to rename the field in the json request/response
    private PlayerProfile playerProfile;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    @Override
    public String toString() {
        return "Player [" + "id=" + id + ", name='" + name + "', playerProfile=" + playerProfile + ']';
    }
}
