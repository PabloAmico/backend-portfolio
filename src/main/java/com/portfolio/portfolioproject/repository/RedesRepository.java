package com.portfolio.portfolioproject.repository;

import com.portfolio.portfolioproject.model.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepository extends JpaRepository<Redes, Long> {
    
}
