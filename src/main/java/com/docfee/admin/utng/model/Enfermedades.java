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
@Table(name="ct_enfermedades")
public class Enfermedades implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_enfermedad")
    private Integer id_enfermedad; 
    
    @Column(name="nombreEnfermedad")
    private String nombreEnfermedad;
}
