package com.example.backend.services;

import com.example.backend.entity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantServiceInterface {
    Etudiant saveEtudiant(Etudiant etudiant);

    Optional<Etudiant> getEtudiantById(Long id);

    List<Etudiant> getAllEtudiants();

    void deleteEtudiant(Long id);
}
