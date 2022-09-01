package com.portfolio.portfolioproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String institucion;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    private String url_imagen;
    
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    public Educacion(){
    }
    
    public Persona GetPersona(){
        return persona;
    }
    
    public void Set_persona(Persona persona){
        this.persona = persona;
    }
    
    
}
