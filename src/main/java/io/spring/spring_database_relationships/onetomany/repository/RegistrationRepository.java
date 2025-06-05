package io.spring.spring_database_relationships.onetomany.repository;

import io.spring.spring_database_relationships.onetomany.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
}
