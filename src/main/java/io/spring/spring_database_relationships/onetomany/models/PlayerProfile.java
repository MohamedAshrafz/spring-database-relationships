package io.spring.spring_database_relationships.onetomany.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // To solve the recursion while serializing
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String twitter;

    @OneToOne(mappedBy = "playerProfile", cascade = CascadeType.ALL)
    @JsonBackReference // For the owned in the relation to solve the recursion issue
    private Player player;

    public PlayerProfile() {
    }

    public PlayerProfile(String twitter) {
        this.twitter = twitter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTwitter() {
        return twitter;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "PlayerProfile [" + "id=" + id + ", twitter='" + twitter + "', player=" + player + ']';
    }
}
