package io.spring.spring_database_relationships.onetoone.services;

import io.spring.spring_database_relationships.onetoone.models.Player;
import io.spring.spring_database_relationships.onetoone.repository.PlayerJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerJPARepository repo;

    @Autowired
    public PlayerService(PlayerJPARepository repo) {
        this.repo = repo;
    }

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Player getPlayerById(int id) {
        return repo.findById(id).get();
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        return repo.save(player);
    }

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }
}
