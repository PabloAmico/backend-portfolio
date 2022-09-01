
package com.portfolio.portfolioproject.repository;

import com.portfolio.portfolioproject.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long>{
    
}
