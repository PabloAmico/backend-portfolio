package com.portfolio.portfolioproject.repository;

import com.portfolio.portfolioproject.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>{
    
}
