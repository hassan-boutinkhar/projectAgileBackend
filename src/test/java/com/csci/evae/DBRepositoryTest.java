package com.csci.evae;

import com.csci.evae.entity.Enseignant;
import com.csci.evae.entity.Etudiant;
import com.csci.evae.entity.Formation;
import com.csci.evae.entity.Promotion;
import com.csci.evae.repository.EnseignantRepository;
import com.csci.evae.repository.EtudiantRepository;
import com.csci.evae.repository.FormationRepository;
import com.csci.evae.repository.PromotionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DBRepositoryTest {

    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;
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
    @Test
    public void testInsertEnseignant() {
        Enseignant enseignant = new Enseignant();
        enseignant.setNoEnseignant(1);
        enseignant.setNom("Doe");
        enseignant.setPrenom("John");
        //enseignant.setPromotions(Arrays.asList(new Promotion()));
        enseignant.setAdresse("123 Rue de Test");
        enseignant.setCp("12345");
        enseignant.setVille("Testville");
        enseignant.setPays("Testland");
        enseignant.setTelPort("123456789");
        enseignant.setEncPersoTel("987654321");
        enseignant.setEncUboTel("456789123");
        enseignant.setEncPersoEmail("john.doe@example.com");
        enseignant.setEncUboEmail("jdoe@university.edu");
        enseignant.setIntNoInsee("1234567890123");
        enseignant.setIntSocNom("Test Company");
        enseignant.setIntSocAdresse("456 Rue de Company");
        enseignant.setIntSocCp("54321");
        enseignant.setIntSocVille("Companyville");
        enseignant.setIntSocPays("Companyland");
        enseignant.setIntFonction("Teacher");
        enseignant.setIntProfEmail("johndoe@company.com");
        enseignant.setIntProfTel("987654321");
        enseignant.setSexe("H");
        enseignant.setType("ENC");
        enseignantRepository.save(enseignant);

        Enseignant insertedEnseignant = enseignantRepository.findEnseignantByNoEnseignant(1);

        assertNotNull(insertedEnseignant);
        assertEquals("Doe", insertedEnseignant.getNom());
        assertEquals("John", insertedEnseignant.getPrenom());
        assertEquals("123 Rue de Test", insertedEnseignant.getAdresse());
        assertEquals("12345", insertedEnseignant.getCp());
        assertEquals("Testville", insertedEnseignant.getVille());
        assertEquals("Testland", insertedEnseignant.getPays());
        assertEquals("123456789", insertedEnseignant.getTelPort());
        assertEquals("987654321", insertedEnseignant.getEncPersoTel());
        assertEquals("456789123", insertedEnseignant.getEncUboTel());
        assertEquals("john.doe@example.com", insertedEnseignant.getEncPersoEmail());
        assertEquals("jdoe@university.edu", insertedEnseignant.getEncUboEmail());
        assertEquals("1234567890123", insertedEnseignant.getIntNoInsee());
        assertEquals("Test Company", insertedEnseignant.getIntSocNom());
        assertEquals("456 Rue de Company", insertedEnseignant.getIntSocAdresse());
        assertEquals("54321", insertedEnseignant.getIntSocCp());
        assertEquals("Companyville", insertedEnseignant.getIntSocVille());
        assertEquals("Companyland", insertedEnseignant.getIntSocPays());
        assertEquals("Teacher", insertedEnseignant.getIntFonction());
        assertEquals("johndoe@company.com", insertedEnseignant.getIntProfEmail());
        assertEquals("987654321", insertedEnseignant.getIntProfTel());
        assertEquals("H", insertedEnseignant.getSexe());
        assertEquals("ENC", insertedEnseignant.getType());

    }
    @Test
    public void testInsertPromotion() {
        Promotion promotion = new Promotion();
        promotion.setAnneePro("2004-2005");
        //promotion.setEtudiants(Arrays.asList(new Etudiant()));
        promotion.setEnseignant(enseignantRepository.findEnseignantByNoEnseignant(1));
        promotion.setFormation(formationRepository.findFormationByCodeFormation("CODE1234"));
        promotion.setSiglePro("INF");
        promotion.setNbEtuSouhaite(50);
        promotion.setEtatPreselection("ENC");
        promotion.setDateRentree(new Date());
        promotion.setLieuRentree("Campus");
        promotion.setDateReponseLp(new Date());
        promotion.setCommentaire("Comment");
        promotion.setDateReponseLalp(new Date());
        promotion.setProcessusStage("12345");
        promotion.setNoEvaluation(1);
        promotion.setNoBareme(1);

        promotionRepository.save(promotion);

        Promotion insertedPromotion = promotionRepository.findPromotionByAnneePro("2004-2005");

        assertNotNull(insertedPromotion);
        assertEquals("2004-2005", insertedPromotion.getAnneePro());
        assertEquals("INF", insertedPromotion.getSiglePro());
        assertEquals(Integer.valueOf(50), insertedPromotion.getNbEtuSouhaite());
        assertEquals("ENC", insertedPromotion.getEtatPreselection());
        assertNotNull(insertedPromotion.getDateRentree());
        assertEquals("Campus", insertedPromotion.getLieuRentree());
        assertNotNull(insertedPromotion.getDateReponseLp());
        assertEquals("Comment", insertedPromotion.getCommentaire());
        assertNotNull(insertedPromotion.getDateReponseLalp());
        assertEquals("12345", insertedPromotion.getProcessusStage());
        assertEquals(Integer.valueOf(1), insertedPromotion.getNoEvaluation());
        assertEquals(Integer.valueOf(1), insertedPromotion.getNoBareme());
    }
    @Test
    public void testCreateUser() {
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
    }


}
