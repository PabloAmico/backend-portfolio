package com.portfolio.portfolioproject.service;


import com.portfolio.portfolioproject.model.Proyecto;
import java.util.List;


public interface IProyectoService {
     public List<Proyecto> findByPersonaId(Long persoId);
    public void crearProyecto(Proyecto pro);
    public void borrarProyecto(Long id);
    public void actualizarProyecto(Proyecto pro);
   
}
