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
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String noEtudiantNat;
    private String anneePro;
    private String codeCom;
    private String noEtudiantUbo;
    private String sexe;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String lieuNaissance;
    private String situation;
    private String nationalite;
    private String telPort;
    private String telFixe;
    private String email;
    private String actuAdresse;
    private String actuCp;
    private String actuVille;
    private String actuPays;
    private String permAdresse;
    private String permCp;
    private String permVille;
    private String permPays;
    private String dernierDiplome;
    private String universite;
    private String sigleEtu;
    private String compteCri;
    private String uboEmail;
    private Integer grpeAnglais;
    private String abandonMotif;
    private Date abandonDate;
    private char estDiplome;
}
