package com.example.backend.controllers;

import com.example.backend.entity.Enseignant;
import com.example.backend.services.EnseignantServiceInterface;
import com.example.backend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.API_URL+"/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantServiceInterface enseignantService;


    @PostMapping
    public ResponseEntity<Enseignant> saveEnseignant(@RequestBody Enseignant enseignant) {
        Enseignant savedEnseignant = enseignantService.saveEnseignant(enseignant);
        return new ResponseEntity<>(savedEnseignant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable Long id) {
        Optional<Enseignant> enseignant = enseignantService.getEnseignantById(id);
        return enseignant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        return new ResponseEntity<>(enseignants, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable Long id) {
        enseignantService.deleteEnseignant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}