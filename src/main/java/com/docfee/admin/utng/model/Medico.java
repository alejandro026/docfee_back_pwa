package com.docfee.admin.utng.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_medicos")
public class Medico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_medico")
    private Integer id_medico;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name = "ApPaterno")
    private String apPaterno;
    
    @Column(name = "ApMaterno")
    private String apMaterno;
    
    @Column(name = "CedulaProfesional")
    private String cedulaProfesional;
    
    @Column(name = "Telefono")
    private String telefono;
    
    @Column(name= "consultorio")
    private String consultorio;

}
