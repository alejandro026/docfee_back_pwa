package com.docfee.admin.utng.handler;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.service.EmailService;
import com.docfee.admin.utng.service.IMensajeService;

@Service
public class MensajeRecordatorioHandler extends Handler{
    
    @Autowired
    IMensajeService mensajeService;
    @Autowired
    EmailService email;
    @Override
    public LoginUsuario ProcessRequest(Solicitud request) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void ProcesaRequestMensjae(Solicitud request){
        //Recupera fecha
        Date fecha= request.getCita().getFecha();
        fecha.setHours(fecha.getHours()+6);
        //Formateador de fecha
        DateFormat FechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat HoraCorta = DateFormat.getTimeInstance(DateFormat.SHORT);

        if(request.getMensaje().getTipoMensaje()==1) {

            StringBuilder mensaje=new StringBuilder();
            mensaje.append("El/La Dr."+request.getCita().getId_medico().getNombre()+' '+request.getCita().getId_medico().getApPaterno()+' '+request.getCita().getId_medico().getApMaterno()+" le recuerda ");
            
                mensaje.append("que tiene una cita programada para el dia "+ FechaLarga.format(fecha));
            
            mensaje.append(" a las "+ HoraCorta.format(fecha));
            request.getMensaje().setMensaje(mensaje.toString());
            request.getMensaje().setNumero(request.getCita().getTratamiento().getId_usuario().getTelefono());
            mensajeService.mensajeWhastapp(request.getMensaje());
            try {
                String para = request.getCita().getTratamiento().getId_usuario().getCorreo();
                String motivo = "Recordatorio de Cita Médica";
                String contenido = mensaje.toString();
                email.enviarEmail(para,motivo,contenido);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else if(nextHandler !=null){
            nextHandler.ProcesaRequestMensjae(request);
        }
        
    }

}
