package com.docfee.admin.utng.dto;

import com.docfee.admin.utng.model.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TratamientoDTO {
    private Integer id_tratamiento;
    
    private Integer id_usuario;
    private Integer id_medico;
    private String descripcion;
    private String iPAS_SisTegumentario;
    private String iPAS_SisMuscular;
    private String iPAS_SisOseo;
    private String iPAS_SisNervioso;
    private String iPAS_SisEndocrino;
    private String iPAS_SisInmunologico;
    private String iPAS_SirCirculatorio;
    private String iPAS_ApaUrinario;
    private String iPAS_ApaRespiratorio;
    private String iPAS_ApaDigestivo;
    private String iPAS_ApaReproductor;
    private Double presionArterial;
    private Double frec_Cardiaca;
    private Double frec_Respiratoria;
    private Double temperaatura;
    private Double altura;
    private Integer imc;
    private String aspectos_Generales;
    private String documentosEstudios;
    private String diagnosticoPresuntivo;
    private String tratamientoEmpleadoIntegral;
}
