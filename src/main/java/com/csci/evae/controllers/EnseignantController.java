package com.csci.evae.controllers;

import com.csci.evae.entity.Enseignant;
import com.csci.evae.services.EnseignantServiceInterface;
import com.csci.evae.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur pour les opérations CRUD sur les enseignants.
 */
@RestController
@RequestMapping(Constants.API_URL+"enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantServiceInterface enseignantService;

    /**
     * Ajouté un nouvel enseignant.
     *
     * @param enseignant Les détails de l'enseignant à ajouter.
     * @return ResponseEntity avec l'enseignant ajouté et le code de statut HTTP.
     */

    @PostMapping
    public ResponseEntity<Enseignant> saveEnseignant(@RequestBody Enseignant enseignant) {
        Enseignant savedEnseignant = enseignantService.saveEnseignant(enseignant);
        return new ResponseEntity<>(savedEnseignant, HttpStatus.CREATED);
    }


    /**
     * Récupère un enseignant par son ID.
     *
     * @param id de l'enseignant à récupérer.
     * @return ResponseEntity contenant l'enseignant trouvé ou un code de statut NOT_FOUND.
     */


    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable Long id) {
        Optional<Enseignant> enseignant = enseignantService.getEnseignantById(id);
        return enseignant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    /**
     * Récupère tous les enseignants.
     *
     * @return ResponseEntity contenant la liste de tous les enseignants ou un code de statut NOT_FOUND.
     */

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        return new ResponseEntity<>(enseignants, HttpStatus.OK);
    }


    /**
     * Supprime un enseignant par son ID.
     *
     * @param id L'ID de l'enseignant à supprimer.
     * @return ResponseEntity avec un code de statut NO_CONTENT.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable Long id) {
        enseignantService.deleteEnseignant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * Update d'un enseignant par son ID.
     *
     * @param id               L'ID de l'enseignant à mettre à jour.
     * @param enseignantDetails Les détails de l'enseignant mis à jour.
     * @return ResponseEntity avec l'enseignant mis à jour et le code de statut HTTP.
     */


    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable Long id, @RequestBody Enseignant enseignantDetails) {
        Enseignant updatedEnseignant = enseignantService.updateEnseignant(id, enseignantDetails);
        return ResponseEntity.ok(updatedEnseignant);
    }
}