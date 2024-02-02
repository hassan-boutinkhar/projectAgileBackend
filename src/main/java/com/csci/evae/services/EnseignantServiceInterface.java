package com.example.backend.services;

import com.example.backend.entity.Enseignant;

import java.util.List;
import java.util.Optional;

public interface EnseignantServiceInterface {
    Enseignant saveEnseignant(Enseignant enseignant);

    Optional<Enseignant> getEnseignantById(Long id);

    List<Enseignant> getAllEnseignants();

    void deleteEnseignant(Long id);
}
