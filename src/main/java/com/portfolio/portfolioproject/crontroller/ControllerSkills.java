package com.portfolio.portfolioproject.crontroller;

import com.portfolio.portfolioproject.model.Skills;
import com.portfolio.portfolioproject.service.IPersonaService;
import com.portfolio.portfolioproject.service.ISkillsService;
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
public class ControllerSkills {
    
     @Autowired
    public IPersonaService persoServ;
     
     @Autowired
     public ISkillsService skiServ;
     
     @GetMapping("/ver/skills/{personaId}")
    public List<Skills> verSkills(@PathVariable(value = "personaId") Long personaId){
        List<Skills> skills = skiServ.findByPersonaId(personaId);
        return skills;
    }
    
    @PostMapping("new/skills/{id}")
    public void agregarSkills( @PathVariable(value= "id") Long id,
                                  @RequestBody Skills ski){
        ski.Set_persona(persoServ.buscarPersona(id));
        skiServ.crearSkills(ski);
    }
    
    @DeleteMapping("delete/skills/{id}")
    public void borrarSkills(@PathVariable(value="id") Long id){
        skiServ.borrarSkills(id);
    }
    
    @PostMapping("/actualizar/skills/{id}")
    public void actualizarExperiencia(  @PathVariable(value="id") Long id,
                                        @RequestBody Skills ski){
         ski.Set_persona(persoServ.buscarPersona(id));
        skiServ.actualizarSkills(ski);
    }
}
