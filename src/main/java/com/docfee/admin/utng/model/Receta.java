package com.docfee.admin.utng.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_recetas")
public class Receta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_receta")
    private Integer id_receta;
    
    @ManyToOne
    @JoinColumn(name="id_cita")
    private Citas id_cita;
    
    @Column(name= "Diagnostico")
    private String diagnostico;
    
    @Column(name= "Edad")
    private Integer edad;
    
    @Column(name= "Fecha")
    private Date fecha;
    
    @Column(name= "Medicamento")
    private String medicamento;
    
    @Column(name= "Horarios")
    private Integer horarios;
    
    @Column(name= "Tareas")
    private String tareas;
    
    @Column(name= "ProximaCita")
    private Date proximaCita;
    
}
