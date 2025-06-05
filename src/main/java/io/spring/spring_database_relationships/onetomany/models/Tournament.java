package io.spring.spring_database_relationships.onetomany.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tournament_id")
    private List<Registration> registrations;

    public Tournament() {
    }

    public Tournament(int id, String name, String location, List<Registration> registrations) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.registrations = registrations;
    }

    public void addRegistration(Registration reg) {
        registrations.add(reg);
    }

    public void removeRegistration(Registration reg) {
        if (reg != null)
            registrations.remove(reg);
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Tournament [id=" + id + ", name=" + name + ", location=" + location + "]";
    }
}
