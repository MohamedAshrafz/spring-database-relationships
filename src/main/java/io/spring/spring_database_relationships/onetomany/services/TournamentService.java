package io.spring.spring_database_relationships.onetomany.services;

import io.spring.spring_database_relationships.onetomany.models.Registration;
import io.spring.spring_database_relationships.onetomany.models.Tournament;
import io.spring.spring_database_relationships.onetomany.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    TournamentRepository repo;

    //get all tournaments
    public List<Tournament> allTournaments() {
        return repo.findAll();
    }
    //get tournament by ID
    public Tournament getTournament(int id){
        return repo.findById(id).get();
    }
    //add tournament
    public Tournament addTournament(Tournament tournament) {
        tournament.setId(0);
        return repo.save(tournament);
    }

    public Tournament addRegistration(int id, Registration registration) {
        Tournament tournament = repo.findById(id).get();
        tournament.addRegistration(registration);

        return repo.save(tournament);
    }

    //delete tournament
    public void deleteTournament(int id) {
        repo.deleteById(id);
    }
}
