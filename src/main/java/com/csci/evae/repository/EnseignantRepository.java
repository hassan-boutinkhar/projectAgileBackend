package com.csci.evae.repository;

import com.csci.evae.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
    Optional<Enseignant> findByNomAndPrenom(String nom, String prenom);
    Enseignant findEnseignantByNoEnseignant(Integer id);
}
