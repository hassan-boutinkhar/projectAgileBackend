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

@Service
public class EnseignantServiceImpl implements EnseignantServiceInterface {

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        checkExistingEnseignant(enseignant);
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Optional<Enseignant> getEnseignantById(Long id) {
        return enseignantRepository.findById(id);
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

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

    @Override
    public void deleteEnseignant(Long id) {
        if (!enseignantRepository.existsById(id)) {
            throw new EntityNotFoundException("Aucun enseignant trouvé avec l'ID : " + id);
        }
        enseignantRepository.deleteById(id);
    }

    private void checkExistingEnseignant(Enseignant enseignant) {
        Optional<Enseignant> existingEnseignant = enseignantRepository.findByNomAndPrenom(
                enseignant.getNom(), enseignant.getPrenom());

        if (existingEnseignant.isPresent()) {
            throw new DuplicateEntityException("Un enseignant avec le même nom, prénom et date de naissance existe déjà.");
        }
    }
}
