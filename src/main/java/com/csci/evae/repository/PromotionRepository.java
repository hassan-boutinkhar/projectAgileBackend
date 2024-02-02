package com.csci.evae.repository;

import com.csci.evae.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,String> {
    Promotion findPromotionByAnneePro(String annee);
}
