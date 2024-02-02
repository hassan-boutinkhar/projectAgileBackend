package com.csci.evae.services;

import com.csci.evae.entity.Enseignant;

import java.util.List;
import java.util.Optional;

public interface EnseignantServiceInterface {
    Enseignant saveEnseignant(Enseignant enseignant);

     Optional<Enseignant> getEnseignantById(Long id);

        List<Enseignant> getAllEnseignants();

    void deleteEnseignant(Long id);
    public Enseignant updateEnseignant(Long id, Enseignant enseignantDetails);
}
