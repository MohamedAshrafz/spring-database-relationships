package io.spring.spring_database_relationships.onetoone.controllers;

import io.spring.spring_database_relationships.onetoone.models.Player;
import io.spring.spring_database_relationships.onetoone.services.PlayerService;
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

    @GetMapping("{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0);
        return playerService.addPlayer(player);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

    @PutMapping("assignProfile")
    public Player assignProfile(@RequestParam int playerId,
                                @RequestParam int profileId) {

        return playerService.assignProfile(playerId, profileId);
    }
}
