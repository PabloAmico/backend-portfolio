package com.portfolio.portfolioproject.crontroller;


import com.portfolio.portfolioproject.model.Educacion;
import com.portfolio.portfolioproject.service.IEducacionService;
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
public class ControllerEducacion {
    
    @Autowired
    public IEducacionService eduServ;
    
     @Autowired
    public IPersonaService persoServ;
    
     
     
     
    @GetMapping("/ver/educacion/{personaId}")
    public List<Educacion> verEdu(@PathVariable(value = "personaId") Long personaId){
        List<Educacion> edus = eduServ.findByPersonaId(personaId);
        return edus;
    }
    
    @PostMapping("/new/educacion/{id}")
    public void agregarEducacion( @PathVariable(value= "id") Long id,
                                  @RequestBody Educacion edu){
        edu.Set_persona(persoServ.buscarPersona(id));
        eduServ.crearEducacion(edu);
    }
    
    @DeleteMapping("/delete/educacion/{id}")
    public void borrarEducacion(@PathVariable(value="id") Long id){
        eduServ.borrarEducacion(id);
    }
    
    @PostMapping("/actualizar/educacion/{id}")
    public void actualizarEducacion(  @PathVariable(value="id") Long id,
                                        @RequestBody Educacion edu){
         edu.Set_persona(persoServ.buscarPersona(id));
        eduServ.actualizarEducacion(edu);
    }
    
    
    @PostMapping("/actualizar/educacion/imagen")
    public void actualizarImagenEducacion(@RequestBody Educacion edu){
        //exp.Set_persona(persoServ.buscarPersona(id));
        Educacion aux;
        aux = eduServ.findEducacion(edu.getId());
        aux.setUrl_imagen(edu.getUrl_imagen());
        System.out.println("actualizando comun....");
        eduServ.actualizarEducacion(aux);
    }
}
