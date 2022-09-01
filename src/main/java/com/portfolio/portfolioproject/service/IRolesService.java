package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Roles;
import java.util.List;


public interface IRolesService {
    public List<Roles> findByPersonaId(Long persoId);
    public void crearRol(Roles rol);
    public void borrarRol(Long id);
    public void actualizarRol(Roles rol);
}
