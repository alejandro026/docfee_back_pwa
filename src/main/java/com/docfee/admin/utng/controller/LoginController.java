package com.docfee.admin.utng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docfee.admin.utng.handler.Handler;
import com.docfee.admin.utng.handler.MedicoHandler;
import com.docfee.admin.utng.handler.PacienteHandler;
import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Solicitud;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    PacienteHandler pacienteHandler= new PacienteHandler();
    
    @Autowired
    MedicoHandler medicoHandler = new MedicoHandler();


    
    
    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public LoginUsuario login(@RequestBody Solicitud request){
        Handler medicoHandler= this.medicoHandler;
        
        Solicitud solicitud = new Solicitud(request.getUsuario(), request.getPassword());
        
        pacienteHandler.SetNextHandler(medicoHandler);
        LoginUsuario respuesta= pacienteHandler.ProcessRequest(solicitud);
        
        
        return respuesta;
        
    }

}
