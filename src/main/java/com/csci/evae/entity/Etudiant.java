package com.csci.evae.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NO_ETUDIANT_NAT", length = 50, nullable = false)
    private String noEtudiantNat;

    @Column(name = "ANNEE_PRO", length = 10, nullable = false)
    private String anneePro;

    @Column(name = "CODE_COM", length = 10)
    private String codeCom;

    @Column(name = "NO_ETUDIANT_UBO", length = 20)
    private String noEtudiantUbo;


    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 50, nullable = false)
    private String prenom;

    @Column(name = "DATE_NAISSANCE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "LIEU_NAISSANCE", length = 255, nullable = false)
    private String lieuNaissance;

    @Column(name = "NATIONALITE", length = 50, nullable = false)
    private String nationalite;

    @Column(name = "TEL_PORT", length = 20)
    private String telPort;

    @Column(name = "TEL_FIXE", length = 20)
    private String telFixe;

    @Column(name = "EMAIL", length = 255)
    private String email;

    @Column(name = "ACTU_ADRESSE", length = 255)
    private String actuAdresse;

    @Column(name = "ACTU_CP", length = 10)
    private String actuCp;

    @Column(name = "ACTU_VILLE", length = 255)
    private String actuVille;

    @Column(name = "ACTU_PAYS", length = 255)
    private String actuPays;

    @Column(name = "PERM_ADRESSE", length = 255, nullable = false)
    private String permAdresse;

    @Column(name = "PERM_CP", length = 10, nullable = false)
    private String permCp;

    @Column(name = "PERM_VILLE", length = 255, nullable = false)
    private String permVille;

    @Column(name = "PERM_PAYS", length = 255, nullable = false)
    private String permPays;

    @Column(name = "DERNIER_DIPLOME", length = 255, nullable = false)
    private String dernierDiplome;

    @Column(name = "UNIVERSITE", length = 255, nullable = false)
    private String universite;

    @Column(name = "SIGLE_ETU", length = 3, nullable = false)
    private String sigleEtu;

    @Column(name = "COMPTE_CRI", length = 10, nullable = false)
    private String compteCri;

    @Column(name = "UBO_EMAIL", length = 255)
    private String uboEmail;

    @Column(name = "GRPE_ANGLAIS")
    private Integer grpeAnglais;

    @Column(name = "ABANDON_MOTIF", length = 255)
    private String abandonMotif;

    @Column(name = "ABANDON_DATE")
    @Temporal(TemporalType.DATE)
    private Date abandonDate;

    @Column(name = "EST_DIPLOME", length = 1)
    private String estDiplome;

    // Foreign key constraint for ANNEE_PRO
    @ManyToOne
    @JoinColumn(name = "ANNEE_PRO", referencedColumnName = "ANNEE_PRO", insertable = false, updatable = false)
    private Promotion promotion;

    // Check constraints
    @Check(constraints = "SITUATION IN ('CEL', 'MAR', 'VEU', 'DIV')")
    @Column(name = "SITUATION", length = 3, nullable = false)
    private String situation;

    @Check(constraints = "SEXE IN ('H', 'F', 'L')")
    @Column(name = "SEXE", length = 1, nullable = false)
    private String sexe;
}
