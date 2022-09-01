package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Roles;
import com.portfolio.portfolioproject.repository.RolesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService implements IRolesService{

    @Autowired
    public RolesRepository rolRepo;
    
    @Override
    public List<Roles> findByPersonaId(Long persoId) {
        List<Roles> rol_aux = rolRepo.findAll();
        List<Roles> rol = rol_aux;
        for(int x = 0; x< rol_aux.size(); x++){
            if(persoId != rol_aux.get(x).GetPersona().Get_Id()){
                rol.remove(rol_aux.get(x));
                System.out.println("Carga");
            }
        }
        return rol;
    }

    @Override
    public void crearRol(Roles rol) {
        rolRepo.save(rol);
    }

    @Override
    public void borrarRol(Long id) {
        rolRepo.deleteById(id);
    }

    @Override
    public void actualizarRol(Roles rol) {
        rolRepo.save(rol);
    }
    
}
