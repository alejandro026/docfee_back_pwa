package com.docfee.admin.utng.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_citas")
public class Citas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cita")
    private Integer id_cita;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_medico")
    private Medico id_medico;
    
   @Column(name = "Fecha")
   private Date fecha;
   
   @Column(name = "Lugar")
   private String lugar;
   
   @Column(name = "Especialidad")
   private String especialidad;
   
   @Column(name = "Notas")
   private String notas;

   @JoinColumn(name="id_tratamiento")
   @OneToOne
   private Tratamiento tratamiento;
   
   @Column(name= "confirmada")
   private Integer confirmada;
   
}
