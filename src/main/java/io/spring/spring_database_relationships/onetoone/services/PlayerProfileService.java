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
        // Because the relationship is bidirectional we must break the association first
        // before deleting the player profile if we do not want to delete the associated player when deleting its profile
        PlayerProfile playerProfile = repo.findById(id).get();

        //set the playerProfile field of the Player object to null
        playerProfile.getPlayer().setPlayerProfile(null);

        //set the player field of the PlayerProfile object to null
        playerProfile.setPlayer(null);

        //save changes
        repo.save(playerProfile);

        //delete the PlayerProfile object
        repo.delete(playerProfile);
    }
}
