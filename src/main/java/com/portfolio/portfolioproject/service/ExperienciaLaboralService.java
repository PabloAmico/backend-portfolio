package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.ExperienciaLaboral;
import com.portfolio.portfolioproject.repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboral {

    @Autowired
    public ExperienciaLaboralRepository expLabRepo;
    
    @Override
    public List<ExperienciaLaboral> findByPersonaId(Long persoId) {
        
        List<ExperienciaLaboral> exp_aux = expLabRepo.findAll();
         List<ExperienciaLaboral> exp = exp_aux;
        for(int x= 0; x < exp_aux.size(); x++){
            if(exp_aux.size() > 0){
                System.out.println(exp_aux.get(x).GetPersona().Get_Id() + " fuera" + persoId);
            }
            if(persoId != exp_aux.get(x).GetPersona().Get_Id()){
                exp.remove(exp_aux.get(x));
                 System.out.println("Carga");
            }
        }
        return exp;
    }

    @Override
    public void crearExperiencia(ExperienciaLaboral exp) {
        expLabRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expLabRepo.deleteById(id);
    }

    @Override
    public void actualziarExperiencia(ExperienciaLaboral exp) {
        expLabRepo.save(exp);
    }

    @Override
    public ExperienciaLaboral findExperiencia(Long id) {
       return expLabRepo.findById(id).orElse(null);
    }
    
}
