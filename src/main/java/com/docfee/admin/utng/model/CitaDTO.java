package com.docfee.admin.utng.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitaDTO {

    

   private Integer id_cita; 
    
   private Integer id_medico;
    
   private Date fecha;
   
   private String lugar;
   
   private String especialidad;
   
   private String notas;

   private Integer tratamiento;
   
   private Integer confirmada;
}
