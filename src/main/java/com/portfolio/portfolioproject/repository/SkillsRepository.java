package com.portfolio.portfolioproject.repository;

import com.portfolio.portfolioproject.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    
}
