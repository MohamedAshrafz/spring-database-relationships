package io.spring.spring_database_relationships.onetomany.services;

import io.spring.spring_database_relationships.onetomany.models.Registration;
import io.spring.spring_database_relationships.onetomany.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository repo;

    //get all registrations
    public List<Registration> allRegistrations() {
        return repo.findAll();
    }
    //get registration by ID
    public Registration getRegistration(int id){
        return repo.findById(id).get();
    }
    //add registration
    public Registration addRegistration(Registration registration) {
        registration.setId(0);
        return repo.save(registration);
    }
    //delete registration
    public void deleteRegistration(int id) {
        repo.deleteById(id);
    }
}
