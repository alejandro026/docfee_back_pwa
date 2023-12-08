package com.docfee.admin.utng.model;
import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class NuevaReceta {
	private Integer id_receta;
	
	private Integer id_cita;
	
	private String diagnostico;
	
	//private Integer edad;
	
	private Date fecha;
	
	private String medicamento;
	
	private Integer horarios;
    
    private String tareas;
    
    //private Date proximaCita;
}
