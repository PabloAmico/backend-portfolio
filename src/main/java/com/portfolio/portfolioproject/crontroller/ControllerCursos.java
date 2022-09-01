package com.portfolio.portfolioproject.crontroller;

import com.portfolio.portfolioproject.model.Cursos;
import com.portfolio.portfolioproject.service.ICursosService;
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
public class ControllerCursos {
    @Autowired
    public IPersonaService persoServ;
    
    @Autowired
    public ICursosService curServ;
    
     @GetMapping("/ver/cursos/{personaId}")
     public List<Cursos> verCursos(@PathVariable(value="personaId") Long personaId){
         List<Cursos> cur = curServ.findByPersonaId(personaId);
         return cur;
     }
     
     @PostMapping("/new/cursos/{id}")
    public void agregarCursos( @PathVariable(value= "id") Long id,
                                  @RequestBody Cursos cur){
        cur.Set_persona(persoServ.buscarPersona(id));
        curServ.crearEducacion(cur);
    }
    
    @DeleteMapping("/delete/curso/{id}")
    public void borrarCursos(@PathVariable(value="id") Long id){
        curServ.borrarEducacion(id);
    }
    
    @PostMapping("/actualizar/curso/{id}")
    public void actualizarCursos(  @PathVariable(value="id") Long id,
                                        @RequestBody Cursos cur){
         cur.Set_persona(persoServ.buscarPersona(id));
        curServ.actualizarEducacion(cur);
    }
    
    @PostMapping("/actualizar/curso/imagen")
    public void actualizarImagenCurso(@RequestBody Cursos cur){
        //exp.Set_persona(persoServ.buscarPersona(id));
        Cursos aux;
        aux = curServ.findCurso(cur.getId());
        aux.setUrl_imagen(cur.getUrl_imagen());
        System.out.println("actualizando comun....");
        curServ.actualizarEducacion(aux);
    }
}
