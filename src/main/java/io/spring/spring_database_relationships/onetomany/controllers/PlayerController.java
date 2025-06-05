package io.spring.spring_database_relationships.onetomany.controllers;

import io.spring.spring_database_relationships.onetomany.models.Player;
import io.spring.spring_database_relationships.onetomany.services.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping(params = "id")
    public Player getPlayerById(@RequestParam int id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("search")
    public List<Player> getPlayerByName(@RequestParam String name) {
        return playerService.getPlayerByName(name);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0);
        return playerService.addPlayer(player);
    }

    @DeleteMapping(params = "id")
    public void deletePlayer(@RequestParam int id) {
        playerService.deletePlayer(id);
    }

    @PutMapping(path = "assignProfile", params = {"id", "profileId"})
    @Transactional
    public Player assignProfile(@RequestParam int id,
                                @RequestParam int profileId) {

        return playerService.assignProfile(id, profileId);
    }

    @PutMapping(path = "tournamentRegistration", params = {"id", "tournamentId"})
    @Transactional
    public Player registerPlayerInTournament(@RequestParam int id,
                                             @RequestParam int tournamentId) {

        return playerService.registerPlayerInTournament(id, tournamentId);
    }
}
