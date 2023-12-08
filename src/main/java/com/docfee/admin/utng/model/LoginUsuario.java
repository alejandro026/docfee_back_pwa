package com.docfee.admin.utng.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUsuario  {
    
    private String id;
    
    private String nombre;
    
    private String tipoUsuario;
    
    private String token;
    
    private Boolean approved=false;
    
    private String mensaje;
    
}
