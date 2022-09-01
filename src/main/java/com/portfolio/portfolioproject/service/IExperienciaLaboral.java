
package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboral {
    public List<ExperienciaLaboral> findByPersonaId(Long persoId);
    public void crearExperiencia(ExperienciaLaboral exp);
    public void borrarExperiencia(Long id);
    public void actualziarExperiencia(ExperienciaLaboral exp);
    public ExperienciaLaboral findExperiencia(Long id);
}
