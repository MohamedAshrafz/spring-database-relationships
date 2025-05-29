package io.spring.spring_database_relationships.onetoone.services;

import io.spring.spring_database_relationships.onetoone.models.PlayerProfile;
import io.spring.spring_database_relationships.onetoone.repository.PlayerProfileJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileService {

    private final PlayerProfileJPARepository repo;

    @Autowired
    public PlayerProfileService(PlayerProfileJPARepository repo) {
        this.repo = repo;
    }

    public List<PlayerProfile> getAllPlayersProfiles() {
        return repo.findAll();
    }

    public PlayerProfile getPlayerProfileById(int id) {
        return repo.findById(id).get();
    }

    public PlayerProfile addPlayerProfile(PlayerProfile player) {
        player.setId(0);
        return repo.save(player);
    }

    public void deletePlayerProfile(int id) {
        repo.deleteById(id);
    }
}
