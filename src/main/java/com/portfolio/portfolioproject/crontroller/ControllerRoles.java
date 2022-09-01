package com.portfolio.portfolioproject.crontroller;

import com.portfolio.portfolioproject.service.IPersonaService;
import com.portfolio.portfolioproject.model.Roles;
import com.portfolio.portfolioproject.service.IRolesService;
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
public class ControllerRoles {
    
    @Autowired
    public IPersonaService persoServ;
    
    @Autowired
    public IRolesService rolServ;
    
    @GetMapping("/ver/rol/{personaId}")
    public List<Roles> verRol(@PathVariable(value="personaId") Long personaId){
        List<Roles> rol = rolServ.findByPersonaId(personaId);
        return rol;
    }
    
    @PostMapping("/new/rol/{id}")
    public void agregarRol(@PathVariable(value= "id") Long id,
                           @RequestBody Roles rol){
        rol.Set_persona(persoServ.buscarPersona(id));
        rolServ.crearRol(rol);
    }
    
    @DeleteMapping("/delete/rol/{id}")
    public void borrarRol(@PathVariable ( value="id") Long id){
        rolServ.borrarRol(id);
    }
    
    @PostMapping("/actualizar/rol/{id}")
    public void actualizarExperiencia(  @PathVariable(value="id") Long id,
                                        @RequestBody Roles rol){
         rol.Set_persona(persoServ.buscarPersona(id));
        rolServ.actualizarRol(rol);
    }
}
