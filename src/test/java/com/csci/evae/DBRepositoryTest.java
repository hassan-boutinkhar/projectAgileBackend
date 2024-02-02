package com.csci.evae;

import com.csci.evae.entity.Etudiant;
import com.csci.evae.entity.Formation;
import com.csci.evae.entity.Promotion;
import com.csci.evae.repository.EtudiantRepository;
import com.csci.evae.repository.FormationRepository;
import com.csci.evae.repository.PromotionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FormationRepositoryTest {

    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Test
    public void testSaveFormation() {
        // Créer une nouvelle formation
        Formation formation = new Formation();
        formation.setCodeFormation("CODE1234");
        formation.setDiplome("BAC");
        formation.setNoAnnee(1);
        formation.setNomFormation("Informatique");
        formation.setDoubleDiplome("N");
        // Définir d'autres propriétés si nécessaire...

        // Enregistrer la formation dans la base de données
        Formation savedFormation = formationRepository.save(formation);

        // Récupérer la formation enregistrée depuis la base de données
        Formation foundFormation = formationRepository.findById(savedFormation.getCodeFormation()).orElse(null);

        // Vérifier si la formation enregistrée est la même que celle insérée
        assertEquals(formation.getCodeFormation(), foundFormation.getCodeFormation());
        assertEquals(formation.getDiplome(), foundFormation.getDiplome());
        assertEquals(formation.getNoAnnee(), foundFormation.getNoAnnee());
        assertEquals(formation.getNomFormation(), foundFormation.getNomFormation());
        assertEquals(formation.getDoubleDiplome(), foundFormation.getDoubleDiplome());
        // Ajouter d'autres assertions si nécessaire...
    }
/*
    @Test
    public void testCreateUser() {
        Promotion promotion =new Promotion();
        promotion.setAnneePro("2004-2005");
        promotion.setSiglePro("SIG2024");
        promotion.setNbEtuSouhaite(100);
        promotion.setEtatPreselection("TER");
        promotion.setDateRentree(new Date());
        promotion.setLieuRentree("Campus");
        promotionRepository.save(promotion);
        Etudiant etudiant = new Etudiant();
        etudiant.setNoEtudiantNat("6589RS236F");
        etudiant.setAnneePro("2004-2005");
        etudiant.setCodeCom("CILI3.2");
        etudiant.setNoEtudiantUbo("200056312");
        etudiant.setSexe("F");
        etudiant.setNom("Arnaldi");
        etudiant.setPrenom("Solenn");
        etudiant.setDateNaissance(new Date(2000,9,02));
        etudiant.setLieuNaissance("Guingamp");
        etudiant.setSituation("CEL");
        etudiant.setNationalite("Française");
        etudiant.setTelPort("06.88.55.78.97");
        etudiant.setTelFixe(null); // Assuming null for the given value
        etudiant.setEmail("solenn.arnaldi@wanadoo.fr");
        etudiant.setActuAdresse("17 rue Laënnec");
        etudiant.setActuCp("29200");
        etudiant.setActuVille("Brest");
        etudiant.setActuPays("France");
        etudiant.setPermAdresse("17 rue Laënnec");
        etudiant.setPermCp("29200");
        etudiant.setPermVille("Brest");
        etudiant.setPermPays("France");
        etudiant.setDernierDiplome("Master1 Informatique");
        etudiant.setUniversite("UBO Brest");
        etudiant.setSigleEtu("SOA");
        etudiant.setCompteCri("arnaldso");
        etudiant.setUboEmail(null); // Assuming null for the given value
        etudiant.setGrpeAnglais(null); // Assuming null for the given value
        etudiant.setAbandonMotif(null); // Assuming null for the given value
        etudiant.setAbandonDate(null); // Assuming null for the given value
        etudiant.setEstDiplome("O");
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        //Etudiant e =etudiantRepository.findById();

        assertThat(savedEtudiant).isNotNull();
        assertThat(savedEtudiant.getId()).isNotNull();
        assertThat(savedEtudiant.getNoEtudiantNat()).isEqualTo("6589RS236F");
    }*/
}
