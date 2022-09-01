package com.portfolio.portfolioproject.service;


import com.portfolio.portfolioproject.model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> findByPersonaId(Long persoId);
    public void crearEducacion(Educacion edu);
    public void borrarEducacion(Long id);
    public void actualizarEducacion(Educacion edu);
    public Educacion findEducacion(Long id);
}
