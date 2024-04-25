package com.csci.evae.services;

import com.csci.evae.entity.Etudiant;

import java.util.List;
import java.util.Optional;

/**
 * Interface définissant les opérations de service pour la gestion des étudiants.
 */
public interface EtudiantServiceInterface {

    /**
     * Ajoute un nouvel étudiant.
     *
     * @param etudiant l'étudiant à enregistrer
     * @return l'étudiant enregistré
     */
    Etudiant saveEtudiant(Etudiant etudiant);

    /**
     * Récupère tous les étudiants.
     *
     * @return une liste de tous les étudiants
     */
    List<Etudiant> getAllEtudiants();

    /**
     * Supprime un étudiant en utilisant son numéro étudiant national.
     *
     * @param noEtudiantNat le numéro étudiant national de l'étudiant à supprimer
     */
    void deleteEtudiant(String noEtudiantNat);

    /**
     * Met à jour les détails d'un étudiant en utilisant son numéro étudiant national.
     *
     * @param noEtudiantNat   le numéro étudiant national de l'étudiant à mettre à jour
     * @param etudiant les nouveaux détails de l'étudiant
     * @return l'étudiant mis à jour
     */
    Etudiant updateEtudiant(String noEtudiantNat, Etudiant etudiant);
}