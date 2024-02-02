package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long noEnseignant;
    private String type;
    private String sexe;
    private String nom;
    private String prenom;
    private String adresse;
    private String cp;
    private String ville;
    private String pays;
    private String telPort;
    private String encPersoTel;
    private String encUboTel;
    private String encPersoEmail;
    private String encUboEmail;
    private String intNoInsee;
    private String intSocNom;
    private String intSocAdresse;
    private String intSocCp;
    private String intSocVille;
    private String intSocPays;
    private String intFonction;
    private String intProfEmail;
    private String intProfTel;
}
