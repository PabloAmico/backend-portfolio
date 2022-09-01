package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Redes;
import com.portfolio.portfolioproject.repository.RedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedesService implements IRedesService{

    @Autowired
    public RedesRepository redRepo;
    
    
    @Override
    public List<Redes> findByPersonaId(Long persoId) {
        List<Redes> red_aux = redRepo.findAll();
         List<Redes> red = red_aux;
        for(int x= 0; x < red_aux.size(); x++){
            if(red_aux.size() > 0){
                System.out.println(red_aux.get(x).GetPersona().Get_Id() + " fuera" + persoId);
            }
            if(persoId != red_aux.get(x).GetPersona().Get_Id()){
                red.remove(red_aux.get(x));
                 System.out.println("Carga");
            }
        }
        return red;
    }

    @Override
    public void crearRedes(Redes red) {
        redRepo.save(red);
    }

    @Override
    public void borrarRedes(Long id) {
        redRepo.deleteById(id);
    }

    @Override
    public void actualizarRedes(Redes red) {
        redRepo.save(red);
    }
    
}
