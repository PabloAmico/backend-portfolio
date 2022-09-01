package com.portfolio.portfolioproject.crontroller;

import com.portfolio.portfolioproject.model.ExperienciaLaboral;
import com.portfolio.portfolioproject.model.Persona;
import com.portfolio.portfolioproject.service.IExperienciaLaboral;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ControllerExpLaboral {
    
    @Autowired
    private IPersonaService persoServ;
    
    @Autowired
    private IExperienciaLaboral expLabServ;
    
    @GetMapping("/ver/experiencia/{personaId}")
    public List<ExperienciaLaboral> verExp(@PathVariable(value = "personaId") Long personaId){
        List<ExperienciaLaboral> exps = expLabServ.findByPersonaId(personaId);
        return exps;
   
    }
    
    @PostMapping("/new/experiencia/{id}")
    public void agregarExperiencia( @PathVariable(value = "id") Long id,
                                    @RequestBody ExperienciaLaboral exp){

        exp.Set_persona(persoServ.buscarPersona(id));
       
        expLabServ.crearExperiencia(exp);
    }
    
    @DeleteMapping("/delete/experiencia/{id}")
    public void borrarExperiencia(@PathVariable(value= "id") Long id){
        expLabServ.borrarExperiencia(id);
    }
    
    @PostMapping("/actualizar/experiencia/{id}")
    public void actualizarExperiencia(@PathVariable(value="id") Long id, @RequestBody ExperienciaLaboral exp){
        exp.Set_persona(persoServ.buscarPersona(id));
        ExperienciaLaboral aux = expLabServ.findExperiencia(exp.getId());
        exp.Set_urlImagen(aux.getUrl_imagen());
        System.out.println("actualizando comun....");
        expLabServ.actualziarExperiencia(exp);
    }
    
    @PostMapping("/actualizar/experiencia/imagen")
    public void actualizarImagenExperiencia(@RequestBody ExperienciaLaboral exp){
        //exp.Set_persona(persoServ.buscarPersona(id));
        ExperienciaLaboral aux;
        aux = expLabServ.findExperiencia(exp.getId());
        aux.Set_urlImagen(exp.getUrl_imagen());
        System.out.println("actualizando comun....");
        expLabServ.actualziarExperiencia(aux);
    }
}
