package com.docfee.admin.utng.model;

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
@Table(name="tr_tratamiento")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tratamiento")
    private Integer id_tratamiento;
    
    @JoinColumn(name="Id_usuario")
    @ManyToOne
    private Usuario id_usuario;
    
    @Column(name = "id_medico")
    private Integer id_medico;
    
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Column(name = "IPAS_SisTegumentario")
    private String iPAS_SisTegumentario;
    
    @Column(name = "IPAS_SisMuscular")
    private String iPAS_SisMuscular;
    
    @Column(name = "IPAS_SisOseo")
    private String iPAS_SisOseo;
    
    @Column(name = "IPAS_SisNervioso")
    private String iPAS_SisNervioso;
    
    @Column(name = "IPAS_SisEndocrino")
    private String iPAS_SisEndocrino;
    
    @Column(name = "IPAS_SisInmunologico")
    private String iPAS_SisInmunologico;
    
    @Column(name = "IPAS_SirCirculatorio")
    private String iPAS_SirCirculatorio;
    
    @Column(name = "iPAS_ApaUrinario")
    private String iPAS_ApaUrinario;
    
    @Column(name = "IPAS_ApaRespiratorio")
    private String iPAS_ApaRespiratorio;
    
    @Column(name = "IPAS_ApaDigestivo")
    private String iPAS_ApaDigestivo;
    
    @Column(name = "IPAS_ApaReproductor")
    private String iPAS_ApaReproductor;
    
    @Column(name = "PresionArterial")
    private Double presionArterial;
    
    @Column(name = "Frec_Cardiaca")
    private Double frec_Cardiaca;
    
    @Column(name = "Frec_Respiratoria")
    private Double frec_Respiratoria;
    
    @Column(name = "Temperaatura")
    private Double temperaatura;
    
    @Column(name = "Altura")
    private Double altura;
    
    @Column(name = "IMC")
    private Integer imc;
    
    @Column(name = "Aspectos_Generales")
    private String aspectos_Generales;
    
    @Column(name = "DocumentosEstudios")
    private String documentosEstudios;
    
    @Column(name = "DiagnosticoPresuntivo")
    private String diagnosticoPresuntivo;
    
    @Column(name = "TratamientoEmpleadoIntegral")
    private String tratamientoEmpleadoIntegral;
    
}
