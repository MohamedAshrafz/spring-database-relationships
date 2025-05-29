package io.spring.spring_database_relationships.onetoone.repository;

import io.spring.spring_database_relationships.onetoone.models.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileJPARepository extends JpaRepository<PlayerProfile, Integer> {
}
