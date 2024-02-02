package com.example.backend.services.impl;

import com.example.backend.entity.Enseignant;
import com.example.backend.repository.EnseignantRepository;
import com.example.backend.services.EnseignantServiceInterface;
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
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }
}