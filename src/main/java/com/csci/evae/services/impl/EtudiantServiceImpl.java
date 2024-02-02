package com.csci.evae.services.impl;

import com.csci.evae.entity.Etudiant;
import com.csci.evae.exceptions.DuplicateEntityException;
import com.csci.evae.repository.EtudiantRepository;
import com.csci.evae.services.EtudiantServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements EtudiantServiceInterface {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        checkExistingEtudiant(etudiant);
        return etudiantRepository.save(etudiant);
    }


    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant updateEtudiant(String noEtudiantNat, Etudiant etudiantDetails) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findEtudiantByNoEtudiantNat(noEtudiantNat);
        if (!existingEtudiant.isPresent()) {
            throw new EntityNotFoundException("Aucun étudiant trouvé avec INE : " + noEtudiantNat);
        }
        //FIX ME LATER
        //checkExistingEtudiant(etudiantDetails);
        // Vérification pour les doublons
        // Gérer les exception

        Etudiant updatedEtudiant = existingEtudiant.get();
        BeanUtils.copyProperties(etudiantDetails, updatedEtudiant, "id");
        return etudiantRepository.save(updatedEtudiant);
    }


    @Override
    public void deleteEtudiant(String noEtudiantNat) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findEtudiantByNoEtudiantNat(noEtudiantNat);
        if (!existingEtudiant.isPresent()) {
            throw new EntityNotFoundException("Aucun étudiant trouvé avec INE : " + noEtudiantNat);
        }
        etudiantRepository.deleteEtudiantByNoEtudiantNat(noEtudiantNat);
    }

    private void checkExistingEtudiant(Etudiant etudiant) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findByNomAndPrenomAndDateNaissance(
                etudiant.getNom(), etudiant.getPrenom(), etudiant.getDateNaissance());

        if (existingEtudiant.isPresent()) {
            throw new DuplicateEntityException("Un étudiant avec le même nom, prénom et date de naissance existe déjà.");        }
    }
}