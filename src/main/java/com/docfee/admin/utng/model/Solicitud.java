package com.docfee.admin.utng.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Solicitud {
    
    public Solicitud(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.approved = false;
    }

    private String usuario;
    
    private String password;
    
    private Mensaje mensaje;
    
    public boolean approved;

    private Citas cita;
    
    private Receta receta;
}
