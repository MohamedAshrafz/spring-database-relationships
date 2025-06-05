package io.spring.spring_database_relationships.onetomany.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // To solve the recursion while serializing
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // To make The one-to-one unidirectional relation
    @OneToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference // For the owning the relation side to solve the recursion issue
    // Name the foreign key column profile_id that's mapped from id in the PlayerProfile entity
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
//    @JsonProperty("profile") // to rename the field in the json request/response
    private PlayerProfile playerProfile;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Registration> registrations;

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

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public void addRegistration(Registration reg) {
        registrations.add(reg);
    }

    //updated toString method
    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", playerProfile=" + playerProfile + ", registrations=" + registrations + "]";
    }
}
