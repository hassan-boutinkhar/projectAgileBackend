package com.csci.evae.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Promotion {
    @Id
    @Column(name = "ANNEE_PRO", length = 10, nullable = false)
    private String anneePro;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    private Enseignant enseignant;
    @ManyToOne
    @JoinColumn(name = "code_formation", referencedColumnName = "code_formation")
    private Formation formation;

    @Column(name = "SIGLE_PRO", length = 5, nullable = false)
    private String siglePro;

    @Column(name = "NB_ETU_SOUHAITE", nullable = false)
    private Integer nbEtuSouhaite;

    @Check(constraints = "ETAT_PRESELECTION BETWEEN 'TER' AND 'TER' OR ETAT_PRESELECTION BETWEEN 'ENC' AND 'ENC'")
    @Column(name = "ETAT_PRESELECTION", length = 3, nullable = false)
    private String etatPreselection;

    @Column(name = "DATE_RENTREE")
    @Temporal(TemporalType.DATE)
    private Date dateRentree;

    @Column(name = "LIEU_RENTREE", length = 255)
    private String lieuRentree;

    @Column(name = "DATE_REPONSE_LP")
    @Temporal(TemporalType.DATE)
    private Date dateReponseLp;

    @Column(name = "COMMENTAIRE", length = 255)
    private String commentaire;

    @Column(name = "DATE_REPONSE_LALP")
    @Temporal(TemporalType.DATE)
    private Date dateReponseLalp;

    @Column(name = "PROCESSUS_STAGE", length = 5)
    private String processusStage;

    @Column(name = "NO_EVALUATION")
    private Integer noEvaluation;

    @Column(name = "NO_BAREME")
    private Integer noBareme;
}
