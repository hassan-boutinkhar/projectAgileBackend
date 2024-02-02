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

@RestController
@RequestMapping(Constants.API_URL+"etudiants")

public class EtudiantController {

    @Autowired
    private EtudiantServiceInterface etudiantService;

    @PostMapping
    public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.saveEtudiant(etudiant);
        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @DeleteMapping("/{noEtudiantNat}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable String noEtudiantNat) {
        etudiantService.deleteEtudiant(noEtudiantNat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{noEtudiantNat}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable String noEtudiantNat, @RequestBody Etudiant etudiantDetails) {
            Etudiant updatedEtudiant = etudiantService.updateEtudiant(noEtudiantNat, etudiantDetails);
            return ResponseEntity.ok(updatedEtudiant);
    }
}