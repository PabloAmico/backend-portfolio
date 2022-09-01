package com.portfolio.portfolioproject.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class InformacionFull {
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
    
}
