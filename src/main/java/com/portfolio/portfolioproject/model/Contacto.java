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
public class Contacto {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
     private String telefono;
     private String mail;
     
     @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
     
     public Persona GetPersona(){
        return persona;
    }
    
    public void Set_persona(Persona persona){
        this.persona = persona;
    }
}
