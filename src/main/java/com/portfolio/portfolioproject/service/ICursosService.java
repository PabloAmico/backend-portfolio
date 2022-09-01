package com.portfolio.portfolioproject.service;


import com.portfolio.portfolioproject.model.Cursos;
import java.util.List;


public interface ICursosService {
    public List<Cursos> findByPersonaId(Long persoId);
    public void crearEducacion(Cursos cur);
    public void borrarEducacion(Long id);
    public void actualizarEducacion(Cursos cur);
    public Cursos findCurso(Long id);
}
