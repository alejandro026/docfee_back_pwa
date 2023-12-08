package com.docfee.admin.utng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="tb_Antecedentes")
public class Antecedentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_antecedente")
    private Integer id_antecedente;
    
    @Column(name="medicamentos")
    private String medicamentos;
    
    @Column(name="Alcolismo")
    private Boolean alcolismo;
    
    @Column(name="Drogas")
    private Boolean drogas;
    
    @Column(name="Tabaquismo")
    private Boolean tabaquismo;
    
    @Column(name="antecedentesFamiliares")
    private String antecedentesFamiliares;
    
    @Column(name="OtrosDatos")
    private String otrosDatos;
    
    @Column(name = "id_usuario")
    private Integer id_usuario;

}
