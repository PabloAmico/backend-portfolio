package com.portfolio.portfolioproject.crontroller;

import com.portfolio.portfolioproject.model.Contacto;
import com.portfolio.portfolioproject.model.Educacion;
import com.portfolio.portfolioproject.service.IContactoService;
import com.portfolio.portfolioproject.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ControllerContacto {
    
    @Autowired
    public IContactoService contServ;
    
    @Autowired
    public IPersonaService persoServ;
    
    @GetMapping("/ver/contacto/{personaId}")
    public List<Contacto> verContacto(@PathVariable(value = "personaId") Long personaId){
        List<Contacto> cont = contServ.findByPersonaId(personaId);
        return cont;
    }
        
    @PostMapping("new/contacto/{id}")
    public void agregarContacto(@PathVariable(value= "id") Long id,
                                @RequestBody Contacto cont){
        cont.Set_persona(persoServ.buscarPersona(id));
        contServ.crearContacto(cont);
    }     
    
    @DeleteMapping("delete/contacto/{id}")
    public void borrarEducacion(@PathVariable(value="id") Long id){
        contServ.borrarContacto(id);
    }
    
    @PostMapping("/actualizar/contacto/")
    public void actualizarContacto( @RequestBody Contacto cont){
        Contacto Aux = contServ.findContacto(cont.getId());
        Aux.setMail(cont.getMail());
        Aux.setTelefono(cont.getTelefono());
        contServ.actualizarContacto(Aux);
    }
}
