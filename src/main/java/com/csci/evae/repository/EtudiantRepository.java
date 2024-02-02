package com.csci.evae.repository;

import com.csci.evae.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Optional<Etudiant> findByNomAndPrenomAndDateNaissance(String nom, String prenom, Date dateNaissance);
    Optional<Etudiant> findEtudiantByNoEtudiantNat(String noEtudiantNat);
    void deleteEtudiantByNoEtudiantNat(String noEtudiantNat);
}
