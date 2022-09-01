package com.portfolio.portfolioproject.crontroller;


import com.portfolio.portfolioproject.model.Redes;
import com.portfolio.portfolioproject.service.IPersonaService;
import com.portfolio.portfolioproject.service.IRedesService;
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
public class ControllerRedes {
    
      @Autowired
    public IPersonaService persoServ;
      
      @Autowired
      public IRedesService redServ;
      
       @GetMapping("/ver/redes/{personaId}")
    public List<Redes> verRed(@PathVariable(value = "personaId") Long personaId){
        List<Redes> red = redServ.findByPersonaId(personaId);
        return red;
    }
    
    @PostMapping("new/redes/{id}")
    public void agregarRedes( @PathVariable(value= "id") Long id,
                                  @RequestBody Redes red){
        red.Set_persona(persoServ.buscarPersona(id));
        redServ.crearRedes(red);
    }
    
    @DeleteMapping("delete/redes/{id}")
    public void borrarRedes(@PathVariable(value="id") Long id){
        redServ.borrarRedes(id);
    }
    
    @PostMapping("/actualizar/redes/{id}")
    public void actualizarRedes(  @PathVariable(value="id") Long id,
                                        @RequestBody Redes red){
         red.Set_persona(persoServ.buscarPersona(id));
        redServ.actualizarRedes(red);
    }
}
