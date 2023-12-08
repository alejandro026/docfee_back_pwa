package com.docfee.admin.utng.service;

import java.io.IOException;

import com.docfee.admin.utng.model.Mensaje;
import com.docfee.admin.utng.model.Usuario;
import com.twilio.rest.api.v2010.account.Message;

public interface IMensajeService {
    
    public Message mensajeWhastapp(Mensaje user);
    
    public Message mensajeSms(Usuario user);
    

    Message mensajeAutenticacion(Mensaje user);

    void correo(Mensaje mensaje) throws IOException;
}
