package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Proyecto;
import com.portfolio.portfolioproject.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository proyRepo;
    
    @Override
    public List<Proyecto> findByPersonaId(Long persoId) {
       List<Proyecto> proy_aux = proyRepo.findAll();
         List<Proyecto> proy = proy_aux;
        for(int x= 0; x < proy_aux.size(); x++){
            if(proy_aux.size() > 0){
                System.out.println(proy_aux.get(x).GetPersona().Get_Id() + " fuera" + persoId);
            }
            if(persoId != proy_aux.get(x).GetPersona().Get_Id()){
                proy.remove(proy_aux.get(x));
                 System.out.println("Carga");
            }
        }
        return proy;
    }

    @Override
    public void crearProyecto(Proyecto pro) {
        proyRepo.save(pro);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyRepo.deleteById(id);
    }

    @Override
    public void actualizarProyecto(Proyecto pro) {
        proyRepo.save(pro);
    }
    
}
