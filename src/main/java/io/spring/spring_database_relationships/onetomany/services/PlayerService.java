package io.spring.spring_database_relationships.onetomany.services;

import io.spring.spring_database_relationships.onetomany.models.Player;
import io.spring.spring_database_relationships.onetomany.models.PlayerProfile;
import io.spring.spring_database_relationships.onetomany.models.Registration;
import io.spring.spring_database_relationships.onetomany.models.Tournament;
import io.spring.spring_database_relationships.onetomany.repository.PlayerProfileRepository;
import io.spring.spring_database_relationships.onetomany.repository.PlayerRepository;
import io.spring.spring_database_relationships.onetomany.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepo;
    private final PlayerProfileRepository playerProfileRepository;
    private final TournamentRepository tournamentRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepo, PlayerProfileRepository playerProfileRepository, TournamentRepository tournamentRepository) {
        this.playerRepo = playerRepo;
        this.playerProfileRepository = playerProfileRepository;
        this.tournamentRepository = tournamentRepository;
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
        PlayerProfile profile = playerProfileRepository.findById(profileId).get();

        player.setPlayerProfile(profile);
        return playerRepo.save(player);
    }

    public Player registerPlayerInTournament(int playerId, int tournamentId) {
        Player player = getPlayerById(playerId);
        Tournament tournament = tournamentRepository.findById(tournamentId).get();

        Registration newReg = new Registration(player, tournament);
        tournament.addRegistration(newReg);

        // not needed because of the @Transactional
//        tournamentRepository.save(tournament);

        return playerRepo.save(player);
    }
}
