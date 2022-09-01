package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Educacion;
import com.portfolio.portfolioproject.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> findByPersonaId(Long persoId) {
        List<Educacion> edu_aux = eduRepo.findAll();
         List<Educacion> edu = edu_aux;
        for(int x= 0; x < edu_aux.size(); x++){
            if(edu_aux.size() > 0){
                System.out.println(edu_aux.get(x).GetPersona().Get_Id() + " fuera" + persoId);
            }
            if(persoId != edu_aux.get(x).GetPersona().Get_Id()){
                edu.remove(edu_aux.get(x));
                 System.out.println("Carga");
            }
        }
        return edu;
    }

    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public void actualizarEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public Educacion findEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

   
    
}
