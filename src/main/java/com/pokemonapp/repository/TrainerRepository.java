package com.pokemonapp.repository;

import com.pokemonapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findById(long id);
    Optional<Trainer> findByUsername(String name);
    Optional<Trainer> findByPicture(String name);
    //@Query("DELETE * FROM Trainer WHERE username=?, nativeQuery = true")
    void deleteByUsername(String username);
}