package com.portfolio.portfolioproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    

    private String nombre;
    private String apellido;
    private String ciudad;
    private String fechaNac;
    private String edad;
    private String imagen_perfil;
    private String imagen_banner;
    private String sobre_mi;
    
    
    public Persona(){
        
    }
    
    public Persona(Long id, String nombre, String apellido,String ciudad,String fechaNac,String edad,String imagen_perfil,String imagen_banner,String sobre_mi){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.imagen_perfil = imagen_perfil;
        this.imagen_banner = imagen_banner;
        this.sobre_mi = sobre_mi;
    }
    
    public Long Get_Id(){
        return this.id;
    }
}
