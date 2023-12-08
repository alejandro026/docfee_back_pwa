package com.docfee.admin.utng.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docfee.admin.utng.handler.Handler;
import com.docfee.admin.utng.handler.MensajeCitaNuevaHandler;
import com.docfee.admin.utng.handler.MensajeMedicamentoHandler;
import com.docfee.admin.utng.handler.MensajeRecordatorioHandler;
import com.docfee.admin.utng.model.Mensaje;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.model.Usuario;
import com.docfee.admin.utng.service.IMensajeService;
import com.twilio.rest.api.v2010.account.Message;

@RestController
@CrossOrigin
@RequestMapping("/mensaje")
public class MensajeController {
    
    @Autowired
    MensajeCitaNuevaHandler mensajeCitaNuevaHandler= new MensajeCitaNuevaHandler();
    
    @Autowired
    MensajeMedicamentoHandler mensajeMedicamentoHandler= new MensajeMedicamentoHandler();
    
    @Autowired
    MensajeRecordatorioHandler mensajeRecordatorioHandler = new MensajeRecordatorioHandler();

    @Autowired
    private IMensajeService service;
    
    @PostMapping(path = "/whatsapp", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void whatsapp(@RequestBody Solicitud mensaje){
        Handler mensajeMedicamentoHandler=this.mensajeMedicamentoHandler;
        Handler mensajeRecordatorioHandler=this.mensajeRecordatorioHandler;
        
        this.mensajeCitaNuevaHandler.SetNextHandler(mensajeRecordatorioHandler);
        this.mensajeRecordatorioHandler.SetNextHandler(mensajeMedicamentoHandler);
        
        mensajeCitaNuevaHandler.ProcesaRequestMensjae(mensaje);
          
    }
    
    @PostMapping(path = "/sms", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message sms(@RequestBody Usuario usuario){
        
        Message mensaje = service.mensajeSms(usuario);
        
        return mensaje;
        
    }
    
    @PostMapping(path = "/autorizacion", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void autenticacion(@RequestBody Mensaje usuario) throws IOException{
        
        service.correo(usuario);
        
//        return mensaje;
        
    }
    
//    @GetMapping(path = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Boolean email() throws IOException{
//        
//        service.correo();
//        
//        return true;
//        
//    }
}
