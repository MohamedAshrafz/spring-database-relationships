package io.spring.spring_database_relationships.onetoone.repository;

import io.spring.spring_database_relationships.onetoone.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJPARepository extends JpaRepository<Player, Integer> {
}
