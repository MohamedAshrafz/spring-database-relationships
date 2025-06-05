package io.spring.spring_database_relationships.onetomany.controllers;

import io.spring.spring_database_relationships.onetomany.models.PlayerProfile;
import io.spring.spring_database_relationships.onetomany.services.PlayerProfileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profiles")
public class PlayerProfileController {

    private final PlayerProfileService playerProfileService;

    @Autowired
    public PlayerProfileController(PlayerProfileService playerProfileService) {
        this.playerProfileService = playerProfileService;
    }

    @GetMapping
    public List<PlayerProfile> getAllPlayersProfiles() {
        return playerProfileService.getAllPlayersProfiles();
    }

    @GetMapping(params = "id")
    public PlayerProfile getPlayerProfileById(@RequestParam("id") int playerId) {
        return playerProfileService.getPlayerProfileById(playerId);
    }

    @PostMapping
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile playerProfile) {
        playerProfile.setId(0);
        return playerProfileService.addPlayerProfile(playerProfile);
    }

    @DeleteMapping(params = "id")
    @Transactional
    public void deletePlayerProfile(@RequestParam int id) {
        playerProfileService.deletePlayerProfile(id);
    }
}
