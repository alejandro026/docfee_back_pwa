package com.docfee.admin.utng.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VistaTratamiento {
    private Integer id_tratamiento;
    
    private Integer id_usuario;
    
    private String nombre_completo;
    
    private String descripcion;
    
    private String aspectos_generales;
    
    private String diagnostico_presuntivo;
    
    private String tratamiento_integral;
    
    private Integer id_antecedentes;
    
}
