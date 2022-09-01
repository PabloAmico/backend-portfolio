package com.portfolio.portfolioproject.crontroller;


import com.portfolio.portfolioproject.model.Proyecto;
import com.portfolio.portfolioproject.service.IPersonaService;
import com.portfolio.portfolioproject.service.IProyectoService;
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
public class ControllerProyectos {
     @Autowired
    public IPersonaService persoServ;
     
     @Autowired
     public IProyectoService proyServ;
     
      @GetMapping("/ver/proyecto/{personaId}")
    public List<Proyecto> verProyecto(@PathVariable(value = "personaId") Long personaId){
        List<Proyecto> proy = proyServ.findByPersonaId(personaId);
        return proy;
    }
    
     @PostMapping("/new/proyecto/{id}")
    public void agregarEducacion( @PathVariable(value= "id") Long id,
                                  @RequestBody Proyecto proy){
        proy.Set_persona(persoServ.buscarPersona(id));
        proyServ.crearProyecto(proy);
    }
    
    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarEducacion(@PathVariable(value="id") Long id){
        proyServ.borrarProyecto(id);
    }
    
    @PostMapping("/actualizar/proyecto/{id}")
    public void actualizarEducacion(  @PathVariable(value="id") Long id,
                                        @RequestBody Proyecto proy){
         proy.Set_persona(persoServ.buscarPersona(id));
        proyServ.actualizarProyecto(proy);
    }
}
