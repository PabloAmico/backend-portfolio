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
public class ExperienciaLaboral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre_empresa;
    private String fecha_inicio;
    private String fecha_fin;
    private String descripcion;
    private String url_imagen;
    
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    public ExperienciaLaboral(){
        
    }
    
    
    public Persona GetPersona(){
        return persona;
    }
    
    public void Set_id(Long id){
        this.id = id;
    }
    
    public void Set_empresa(String nombre_empresa){
        this.nombre_empresa = nombre_empresa;
    }
    
    public void Set_inicio(String fecha_inicio){
        this.fecha_inicio = fecha_inicio;
    }
    
    public void Set_fin(String fecha_fin){
        this.fecha_fin = fecha_fin;
    }
    
    public void Set_descripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void Set_urlImagen(String url_imagen){
        this.url_imagen = url_imagen;
    }
    

    public void Set_persona(Persona persona){
        this.persona = persona;
    }
}
