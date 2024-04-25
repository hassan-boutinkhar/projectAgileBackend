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

/**
 * Implémentation du service pour la gestion des Etudiants.
 */

@Service
public class EtudiantServiceImpl implements EtudiantServiceInterface {

    @Autowired
    private EtudiantRepository etudiantRepository;

    /**
     * Ajoute un nouvel Etudiant.
     *
     * @param etudiant L'objet Etudiant à ajouter.
     * @return L'objet Etudiant ajouté.
     * @throws DuplicateEntityException Si un Etudiant avec le même nom, prénom et date de naissance existe déjà.
     */

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        checkExistingEtudiant(etudiant);
        return etudiantRepository.save(etudiant);
    }


    /**
     * Récupère tous les étudiants.
     *
     * @return une liste de tous les étudiants
     */

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }


    /**
     * Met à jour les détails d'un étudiant.
     *
     * @param noEtudiantNat   le numéro étudiant national de l'étudiant à mettre à jour
     * @param etudiantDetails les nouveaux détails de l'étudiant
     * @return l'étudiant mis à jour
     * @throws EntityNotFoundException si aucun étudiant n'est trouvé avec le numéro étudiant national spécifié
     */

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


    /**
     * Supprime un étudiant.
     *
     * @param noEtudiantNat le numéro étudiant national de l'étudiant à supprimer
     * @throws EntityNotFoundException si aucun étudiant n'est trouvé avec le numéro étudiant national spécifié
     */

    @Override
    public void deleteEtudiant(String noEtudiantNat) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findEtudiantByNoEtudiantNat(noEtudiantNat);
        if (!existingEtudiant.isPresent()) {
            throw new EntityNotFoundException("Aucun étudiant trouvé avec INE : " + noEtudiantNat);
        }
        etudiantRepository.deleteEtudiantByNoEtudiantNat(noEtudiantNat);
    }


    /**
     * Vérifie s'il existe déjà un étudiant avec le même nom, prénom et date de naissance.
     * Si c'est le cas, lance une exception.
     *
     * @param etudiant l'étudiant à vérifier
     * @throws DuplicateEntityException si un étudiant avec les mêmes détails existe déjà
     */

    private void checkExistingEtudiant(Etudiant etudiant) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findByNomAndPrenomAndDateNaissance(
                etudiant.getNom(), etudiant.getPrenom(), etudiant.getDateNaissance());

        if (existingEtudiant.isPresent()) {
            throw new DuplicateEntityException("Un étudiant avec le même nom, prénom et date de naissance existe déjà.");        }
    }
}