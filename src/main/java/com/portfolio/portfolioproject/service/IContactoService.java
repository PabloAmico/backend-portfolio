package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Contacto;
import java.util.List;

public interface IContactoService {
    public List<Contacto> findByPersonaId(Long persoId);
    public void crearContacto(Contacto cont);
    public void borrarContacto(Long id);
    public void actualizarContacto(Contacto cont);
    public Contacto findContacto(Long id);
}
