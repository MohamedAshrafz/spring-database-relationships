package io.spring.spring_database_relationships.onetomany.repository;

import io.spring.spring_database_relationships.onetomany.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("SELECT p FROM Player p WHERE name LIKE %:playerName%")
    public List<Player> findPlayerByName(@Param("playerName") String name);
}
