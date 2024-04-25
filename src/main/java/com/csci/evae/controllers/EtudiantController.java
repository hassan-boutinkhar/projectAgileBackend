package com.csci.evae.controllers;

import com.csci.evae.entity.Etudiant;
import com.csci.evae.services.EtudiantServiceInterface;
import com.csci.evae.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur pour les opérations CRUD sur les étudiants.
 */
@RestController
@RequestMapping(Constants.API_URL+"etudiants")

public class EtudiantController {

    @Autowired
    private EtudiantServiceInterface etudiantService;

    /**
     * Ajouté un nouvel étudiant.
     *
     * @param etudiant Les détails de l'étudiant à ajouter.
     * @return ResponseEntity contenant l'étudiant ajouté et le code de statut HTTP.
     */

    @PostMapping
    public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.saveEtudiant(etudiant);
        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }

    /**
     * Récupère tous les étudiants.
     *
     * @return ResponseEntity contenant la liste de tous les étudiants ou un code de statut NOT_FOUND.
     */

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    /**
     * Supprime un étudiant par son numéro national.
     *
     * @param noEtudiantNat Le numéro national de l'étudiant à supprimer.
     * @return ResponseEntity avec un code de statut NO_CONTENT.
     */


    @DeleteMapping("/{noEtudiantNat}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable String noEtudiantNat) {
        etudiantService.deleteEtudiant(noEtudiantNat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Update d'un étudiant par son numéro national.
     *
     * @param noEtudiantNat   Le numéro national de l'étudiant à mettre à jour.
     * @param etudiantDetails Les détails de l'étudiant mis à jour.
     * @return ResponseEntity avec l'étudiant mis à jour et le code de statut HTTP.
     */

    @PutMapping("/{noEtudiantNat}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable String noEtudiantNat, @RequestBody Etudiant etudiantDetails) {
            Etudiant updatedEtudiant = etudiantService.updateEtudiant(noEtudiantNat, etudiantDetails);
            return ResponseEntity.ok(updatedEtudiant);
    }
}