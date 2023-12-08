package com.docfee.admin.utng.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mensaje {
    private String numero;
    
    private String mensaje;
    
    private String nombreMedico;
    
    private int tipoMensaje;
    
    private Integer idUsuario;
    
    private String correo;
    
    private String nombreUsuario;
}
