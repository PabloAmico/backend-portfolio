package com.portfolio.portfolioproject.crontroller;

import com.portfolio.portfolioproject.model.ExperienciaLaboral;
import com.portfolio.portfolioproject.model.Persona;
import com.portfolio.portfolioproject.service.IExperienciaLaboral;
import com.portfolio.portfolioproject.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ControllerPersona {
    
    @Autowired
    private IPersonaService persoServ;
    
    /*@GetMapping("/obtener/id")
    public Long obtenerId(){
        return 
    }*/
    
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona per){
        persoServ.crearPersona(per);
    }
    
    @GetMapping("/ver/personas")
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }
    
    @PostMapping("/actualizar/persona")
    public void actualizarExperiencia(@RequestBody Persona pers){
        persoServ.actualizarPersona(pers);
    }
    
    @PostMapping("/actualizar/persona/sobremi")
    public void actualizarSobreMi(@RequestBody Persona pers){
        Persona aux = persoServ.buscarPersona(pers.Get_Id());
        aux.setSobre_mi(pers.getSobre_mi());
        persoServ.actualizarPersona(aux);
    }
    
    @PostMapping("/actualizar/persona/imagen")
    public void actualizarImagen(@RequestBody Persona pers){
        Persona aux = persoServ.buscarPersona(pers.Get_Id());
        aux.setImagen_perfil(pers.getImagen_perfil());
        persoServ.actualizarPersona(aux);
    }
    
    @PostMapping("/actualizar/persona/banner")
    public void actualizarBanner(@RequestBody Persona pers){
        Persona aux = persoServ.buscarPersona(pers.Get_Id());
        aux.setImagen_banner(pers.getImagen_banner());
        persoServ.actualizarPersona(aux);
    }
}
