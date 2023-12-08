package com.docfee.admin.utng.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.service.IMensajeService;

@Service
public class MensajeCitaNuevaHandler extends Handler{
    
    @Autowired
    IMensajeService mensajeService;

    @Override
    public LoginUsuario ProcessRequest(Solicitud request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void ProcesaRequestMensjae(Solicitud request) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoHoras = new SimpleDateFormat("hh:mm aa");
       
        if(request.getMensaje().getTipoMensaje()==0) {
                StringBuilder mensaje=new StringBuilder();
                mensaje.append("Hola "+ request.getCita().getTratamiento().getId_usuario().getNombre()+ ". \n");
                mensaje.append("Una cita nueva ha sido reservada por El/La Dr."+ request.getMensaje().getNombreMedico());
                mensaje.append(", para el dia "+ formatoFecha.format(request.getCita().getFecha()));
                mensaje.append(" a la hora "+ formatoHoras.format(request.getCita().getFecha())+ "\n");
                
                mensaje.append("NOTAS: \n "+request.getCita().getNotas()+" \n \n");
                mensaje.append("Lugar: \n "+ request.getCita().getLugar());
                
                request.getMensaje().setMensaje(mensaje.toString());
                request.getMensaje().setNumero(request.getCita().getTratamiento().getId_usuario().getTelefono());
                mensajeService.mensajeWhastapp(request.getMensaje());
            
        }else if(nextHandler !=null){
            nextHandler.ProcesaRequestMensjae(request);
        }
        
    }

}
