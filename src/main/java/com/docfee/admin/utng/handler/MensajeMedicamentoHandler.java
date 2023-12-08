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
public class MensajeMedicamentoHandler extends Handler{
    
    @Autowired
    IMensajeService mensajeService;

    @Override
    public LoginUsuario ProcessRequest(Solicitud request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void ProcesaRequestMensjae(Solicitud request) {
        Date fecha= new Date();
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        
        int hora, minutos, segundos;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        
        if(request.getMensaje().getTipoMensaje()==2) {
        	 StringBuilder mensaje=new StringBuilder();
             mensaje.append("Hola "+ request.getCita().getTratamiento().getId_usuario().getNombre()+ ". \n");
             mensaje.append("El/La Dr."+ request.getMensaje().getNombreMedico());
             mensaje.append(" le recuerda que debe seguir las siguientes indicaciones tomar "+ request.getReceta().getMedicamento());
             mensaje.append(" cada "+ request.getReceta().getHorarios()+ " Horas");
 
             
             request.getMensaje().setMensaje(mensaje.toString());
             request.getMensaje().setNumero(request.getCita().getTratamiento().getId_usuario().getTelefono());
             mensajeService.mensajeWhastapp(request.getMensaje());
        }
        
    }

}
