package com.csci.evae.repository;

import com.csci.evae.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation,String> {
    Formation findFormationByCodeFormation(String codeFormation);
}
