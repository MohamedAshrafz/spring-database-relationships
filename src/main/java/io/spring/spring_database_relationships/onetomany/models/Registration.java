package io.spring.spring_database_relationships.onetomany.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // To solve the recursion while serializing
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Player must not be deleted if the registration was deleted so we must not add  the REMOVE cascading
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "player_id", referencedColumnName = "id")
//    @JsonManagedReference
    private Player player;

    // Player must not be deleted if the registration was deleted so we must not add  the REMOVE cascading
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "tournament_id", referencedColumnName = "id")
    private Tournament tournament;

    public Registration() {
    }

    public Registration(Player player, Tournament tournament) {
        this.player = player;
        this.tournament = tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    //updated toString method
    @Override
    public String toString() {
        return "Registration [id=" + id + ", player=" + player + "]";
    }
}
