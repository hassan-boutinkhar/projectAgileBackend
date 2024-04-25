package com.csci.evae.services.impl;

import com.csci.evae.entity.Enseignant;
import com.csci.evae.exceptions.DuplicateEntityException;
import com.csci.evae.repository.EnseignantRepository;
import com.csci.evae.services.EnseignantServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service pour la gestion des Enseignants.
 */

@Service
public class EnseignantServiceImpl implements EnseignantServiceInterface {

    @Autowired
    private EnseignantRepository enseignantRepository;

    /**
     * Ajoute un nouvel Enseignant.
     *
     * @param enseignant L'objet Enseignant à ajouter.
     * @return L'objet Enseignant ajouté.
     * @throws DuplicateEntityException Si un Enseignant avec le même nom, prénom et date de naissance existe déjà.
     */

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        checkExistingEnseignant(enseignant);
        return enseignantRepository.save(enseignant);
    }


    /**
     * Récupre un Enseignant par son ID.
     *
     * @param id L'ID de l'Enseignant.
     * @return Un Optional contenant l'Enseignant s'il est trouvé, sinon vide.
     */

    @Override
    public Optional<Enseignant> getEnseignantById(Long id) {
        return enseignantRepository.findById(id);
    }


    /**
     * Récupère tous les enseignants.
     *
     * @return une liste de tous les enseignants
     */

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    /**
     * Met à jour les détails d'un enseignant.
     *
     * @param id               l'identifiant de l'enseignant à mettre à jour
     * @param enseignantDetails les nouveaux détails de l'enseignant
     * @return l'enseignant mis à jour
     * @throws EntityNotFoundException si aucun enseignant n'est trouvé avec l'ID spécifié
     */

    @Override
    public Enseignant updateEnseignant(Long id, Enseignant enseignantDetails) {
        Optional<Enseignant> existingEnseignant = enseignantRepository.findById(id);
        if (!existingEnseignant.isPresent()) {
            throw new EntityNotFoundException("Aucun enseignant trouvé avec l'ID : " + id);
        }
        //FIX ME LATER
        //checkExistingEtudiant(etudiantDetails);
        // Vérification pour les doublons
        // Gérer les exception

        Enseignant updatedEnseignant = existingEnseignant.get();
        BeanUtils.copyProperties(enseignantDetails, updatedEnseignant, "id");
        return enseignantRepository.save(updatedEnseignant);
    }


    /**
     * Supprime un enseignant.
     *
     * @param id l'identifiant de l'enseignant à supprimer
     * @throws EntityNotFoundException si aucun enseignant n'est trouvé avec l'ID spécifié
     */

    @Override
    public void deleteEnseignant(Long id) {
        if (!enseignantRepository.existsById(id)) {
            throw new EntityNotFoundException("Aucun enseignant trouvé avec l'ID : " + id);
        }
        enseignantRepository.deleteById(id);
    }


    /**
     * Vérifie s'il existe déjà un enseignant avec le même nom, prénom et date de naissance.
     * Si c'est le cas, lance une exception.
     *
     * @param enseignant l'enseignant à vérifier
     * @throws DuplicateEntityException si un enseignant avec les mêmes détails existe déjà
     */


    private void checkExistingEnseignant(Enseignant enseignant) {
        Optional<Enseignant> existingEnseignant = enseignantRepository.findByNomAndPrenom(
                enseignant.getNom(), enseignant.getPrenom());

        if (existingEnseignant.isPresent()) {
            throw new DuplicateEntityException("Un enseignant avec le même nom, prénom et date de naissance existe déjà.");
        }
    }
}
