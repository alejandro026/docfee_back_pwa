package com.docfee.admin.utng.model;

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
@Table(name="tr_tratamiento_cita")
public class TratamientoCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tratamiento_cita")
    private Integer id_tratamiento_cita;
    
    @Column(name="id_cita")
    private Integer id_cita;
    
    @Column(name="id_tratamiento")
    private Integer id_tratamiento;

}
