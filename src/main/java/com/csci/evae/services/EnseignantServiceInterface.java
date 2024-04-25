package com.csci.evae.services;

import com.csci.evae.entity.Enseignant;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Interface définissant les opérations de service pour la gestion des enseignants.
 */
public interface EnseignantServiceInterface {

    /**
     * Enregistre un nouvel enseignant.
     *
     * @param enseignant l'enseignant à enregistrer
     * @return l'enseignant enregistré
     */
    Enseignant saveEnseignant(Enseignant enseignant);

    /**
     * Récupère un enseignant par son identifiant.
     *
     * @param id l'identifiant de l'enseignant
     * @return un Optional contenant l'enseignant s'il est trouvé, sinon vide
     */

     Optional<Enseignant> getEnseignantById(Long id);

    /**
     * Récupère tous les enseignants.
     *
     * @return une liste de tous les enseignants
     */

    List<Enseignant> getAllEnseignants();

    /**
     * Supprime un enseignant.
     *
     * @param id l'identifiant de l'enseignant à supprimer
     * @throws EntityNotFoundException si aucun enseignant n'est trouvé avec l'ID spécifié
     */

    void deleteEnseignant(Long id);


    /**
     * Met à jour les détails d'un enseignant.
     *
     * @param id               l'identifiant de l'enseignant à mettre à jour
     * @param enseignantDetails les nouveaux détails de l'enseignant
     * @return l'enseignant mis à jour
     * @throws EntityNotFoundException si aucun enseignant n'est trouvé avec l'ID spécifié
     */

    public Enseignant updateEnseignant(Long id, Enseignant enseignantDetails);
}
