package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Skills;
import java.util.List;

public interface ISkillsService {
    public List<Skills> findByPersonaId(Long persoId);
    public void crearSkills(Skills ski);
    public void borrarSkills(Long id);
    public void actualizarSkills (Skills ski);
}
