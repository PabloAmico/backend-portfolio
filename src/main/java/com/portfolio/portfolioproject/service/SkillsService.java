package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Skills;
import com.portfolio.portfolioproject.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService{

    @Autowired
    public SkillsRepository skiRepo;
    
    @Override
    public List<Skills> findByPersonaId(Long persoId) {
        List<Skills> ski_aux = skiRepo.findAll();
        List<Skills> ski = ski_aux;
        for(int x = 0; x< ski_aux.size(); x++){
            if(persoId != ski_aux.get(x).GetPersona().Get_Id()){
                ski.remove(ski_aux.get(x));
            }
        }
        return ski;
    }

    @Override
    public void crearSkills(Skills ski) {
        skiRepo.save(ski);
    }

    @Override
    public void borrarSkills(Long id) {
        skiRepo.deleteById(id);
    }

    @Override
    public void actualizarSkills(Skills ski) {
        skiRepo.save(ski);
    }
    
}
