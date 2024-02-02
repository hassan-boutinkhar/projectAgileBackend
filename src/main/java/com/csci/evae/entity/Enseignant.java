package com.csci.evae.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enseignant {

    @Id
    @Column(name = "NO_ENSEIGNANT", nullable = false)
    private Integer noEnseignant;

    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 50, nullable = false)
    private String prenom;

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Promotion> promotions;

    @Column(name = "ADRESSE", length = 255, nullable = false)
    private String adresse;

    @Column(name = "CP", length = 10, nullable = false)
    private String cp;

    @Column(name = "VILLE", length = 255, nullable = false)
    private String ville;

    @Column(name = "PAYS", length = 255, nullable = false)
    private String pays;

    @Column(name = "TEL_PORT", length = 20)
    private String telPort;

    @Column(name = "ENC_PERSO_TEL", length = 20)
    private String encPersoTel;

    @Column(name = "ENC_UBO_TEL", length = 20)
    private String encUboTel;

    @Column(name = "ENC_PERSO_EMAIL", length = 255)
    private String encPersoEmail;

    @Column(name = "ENC_UBO_EMAIL", length = 255)
    private String encUboEmail;

    @Column(name = "INT_NO_INSEE", length = 50)
    private String intNoInsee;

    @Column(name = "INT_SOC_NOM", length = 50)
    private String intSocNom;

    @Column(name = "INT_SOC_ADRESSE", length = 255)
    private String intSocAdresse;

    @Column(name = "INT_SOC_CP", length = 10)
    private String intSocCp;

    @Column(name = "INT_SOC_VILLE", length = 255)
    private String intSocVille;

    @Column(name = "INT_SOC_PAYS", length = 255)
    private String intSocPays;

    @Column(name = "INT_FONCTION", length = 50)
    private String intFonction;

    @Column(name = "INT_PROF_EMAIL", length = 255)
    private String intProfEmail;

    @Column(name = "INT_PROF_TEL", length = 20)
    private String intProfTel;

    // Check constraint for SEXE
    @Check(constraints = "SEXE IN ('H', 'F', 'L')")
    @Column(name = "SEXE", length = 1, nullable = false)
    private String sexe;

    // Check constraint for TYPE
    @Check(constraints = "TYPE IN ('ENC', 'INT')")
    @Column(name = "TYPE", length = 10, nullable = false)
    private String type;

}
