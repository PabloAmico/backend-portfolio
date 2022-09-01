package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Redes;
import java.util.List;


public interface IRedesService {
    public List<Redes> findByPersonaId(Long persoId);
    public void crearRedes(Redes red);
    public void borrarRedes(Long id);
    public void actualizarRedes(Redes red);
}
