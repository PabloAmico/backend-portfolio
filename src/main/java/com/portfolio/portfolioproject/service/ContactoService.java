package com.portfolio.portfolioproject.service;

import com.portfolio.portfolioproject.model.Contacto;
import com.portfolio.portfolioproject.repository.ContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactoService implements IContactoService{

    @Autowired
    public ContactoRepository contRepo;
    
    @Override
    public List<Contacto> findByPersonaId(Long persoId) {
         List<Contacto> cont_aux = contRepo.findAll();
         List<Contacto> cont = cont_aux;
        for(int x= 0; x < cont_aux.size(); x++){
            if(cont_aux.size() > 0){
                System.out.println(cont_aux.get(x).GetPersona().Get_Id() + " fuera" + persoId);
            }
            if(persoId != cont_aux.get(x).GetPersona().Get_Id()){
                cont.remove(cont_aux.get(x));
                 System.out.println("Carga");
            }
        }
        return cont;
    }

    @Override
    public void crearContacto(Contacto cont) {
       contRepo.save(cont);
    }

    @Override
    public void borrarContacto(Long id) {
        contRepo.deleteById(id);
    }

    @Override
    public void actualizarContacto(Contacto cont) {
        contRepo.save(cont);
    }

    @Override
    public Contacto findContacto(Long id) {
        return contRepo.findById(id).orElse(null);
    }
    
}
