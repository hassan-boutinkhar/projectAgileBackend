package com.csci.evae.services;

import com.csci.evae.entity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantServiceInterface {
    Etudiant saveEtudiant(Etudiant etudiant);


    List<Etudiant> getAllEtudiants();

    void deleteEtudiant(String noEtudiantNat);

    public Etudiant updateEtudiant(String noEtudiantNat, Etudiant etudiant);
}
