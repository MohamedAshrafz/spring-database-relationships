package io.spring.spring_database_relationships.onetomany.controllers;

import io.spring.spring_database_relationships.onetomany.models.Registration;
import io.spring.spring_database_relationships.onetomany.models.Tournament;
import io.spring.spring_database_relationships.onetomany.services.RegistrationService;
import io.spring.spring_database_relationships.onetomany.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    TournamentService service;

    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public List<Tournament> allTournaments() {
        return service.allTournaments();
    }

    @GetMapping(params = "id")
    public Tournament getTournament(@RequestParam int id) {
        return service.getTournament(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return service.addTournament(tournament);
    }

    @PutMapping(path = "/assignRegistration", params = "id")
    public Tournament addRegistration(@RequestParam int id, @RequestBody Registration registration) {
        return service.addRegistration(id, registration);
    }

    @PutMapping(path = "/assignRegistration", params = {"id", "regId"})
    public Tournament assignRegistration(@RequestParam int id, @RequestParam int regId) {
        Registration registration = registrationService.getRegistration(regId);
        System.out.println("assignRegistration the registration is: " + registration);
        return service.addRegistration(id, registration);
    }

    @DeleteMapping(params = "id")
    public void deleteTournament(@RequestParam int id) {
        service.deleteTournament(id);
    }
}
