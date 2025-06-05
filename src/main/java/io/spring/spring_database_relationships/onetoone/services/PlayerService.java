package io.spring.spring_database_relationships.onetoone.services;

import io.spring.spring_database_relationships.onetoone.models.Player;
import io.spring.spring_database_relationships.onetoone.models.PlayerProfile;
import io.spring.spring_database_relationships.onetoone.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepo;
    private final PlayerProfileService playerProfileService;

    @Autowired
    public PlayerService(PlayerRepository playerRepo, PlayerProfileService playerProfileService) {
        this.playerRepo = playerRepo;
        this.playerProfileService = playerProfileService;
    }

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public Player getPlayerById(int id) {
        return playerRepo.findById(id).get();
    }

    public List<Player> getPlayerByName(String name) {
        return playerRepo.findPlayerByName(name);
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        return playerRepo.save(player);
    }

    public void deletePlayer(int id) {
        playerRepo.deleteById(id);
    }

    public Player assignProfile(int playerId, int profileId) {
        Player player = getPlayerById(playerId);
        PlayerProfile profile = playerProfileService.getPlayerProfileById(profileId);

        player.setPlayerProfile(profile);
        return playerRepo.save(player);
    }
}
