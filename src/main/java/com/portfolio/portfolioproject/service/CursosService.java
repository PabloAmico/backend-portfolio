package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Cursos;
import com.portfolio.portfolioproject.repository.CursosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosService implements ICursosService {
    @Autowired
    public CursosRepository curRepo;

    @Override
    public List<Cursos> findByPersonaId(Long persoId) {
        List<Cursos> cur_aux = curRepo.findAll();
         List<Cursos> cur = cur_aux;
        for(int x= 0; x < cur_aux.size(); x++){
            if(cur_aux.size() > 0){
                System.out.println(cur_aux.get(x).GetPersona().Get_Id() + " fuera" + persoId);
            }
            if(persoId != cur_aux.get(x).GetPersona().Get_Id()){
                cur.remove(cur_aux.get(x));
                 System.out.println("Carga");
            }
        }
        return cur;
    }

    @Override
    public void crearEducacion(Cursos cur) {
        curRepo.save(cur);
    }

    @Override
    public void borrarEducacion(Long id) {
        curRepo.deleteById(id);
    }

    @Override
    public void actualizarEducacion(Cursos cur) {
        curRepo.save(cur);
    }

    @Override
    public Cursos findCurso(Long id) {
        return curRepo.findById(id).orElse(null);
    }
    
    
}
