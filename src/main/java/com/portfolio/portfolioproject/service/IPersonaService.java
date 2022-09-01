package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Persona;
import java.util.List;


public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona (Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public void actualizarPersona(Persona pers);
     //public Long obtenerId();
}
