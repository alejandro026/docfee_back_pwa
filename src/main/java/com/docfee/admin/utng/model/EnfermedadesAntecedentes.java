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
@Table(name="tr_enfermedadesantecedentes")
public class EnfermedadesAntecedentes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Enfermedad_antecedente")
    private Integer id_Enfermedad_antecedente;
    
    @Column(name="id_antecedente")
    private Integer id_antecedente;
    
    @Column(name="id_enfermedad")
    private Integer id_enfermedad;
}
