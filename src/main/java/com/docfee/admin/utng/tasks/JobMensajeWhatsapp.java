package com.docfee.admin.utng.tasks;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.docfee.admin.utng.controller.MensajeController;
import com.docfee.admin.utng.handler.Handler;
import com.docfee.admin.utng.handler.MensajeCitaNuevaHandler;
import com.docfee.admin.utng.handler.MensajeMedicamentoHandler;
import com.docfee.admin.utng.handler.MensajeRecordatorioHandler;
import com.docfee.admin.utng.model.Citas;
import com.docfee.admin.utng.model.Mensaje;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.model.Usuario;
import com.docfee.admin.utng.service.IMensajeService;
import com.docfee.admin.utng.service.CitasService;


@Component
public class JobMensajeWhatsapp {
    private static final Logger LOG = LoggerFactory.getLogger(JobMensajeWhatsapp.class);
    
    @Autowired
    private IMensajeService service;
    @Autowired
    CitasService consultaService;
    //MensajeController mensaje;
    Solicitud solicitud = new Solicitud();
    @Autowired
    MensajeController mensaje;
    // @Autowired
    // MensajeCitaNuevaHandler mensajeCitaNuevaHandler= new MensajeCitaNuevaHandler();
    
    // @Autowired
    // MensajeMedicamentoHandler mensajeMedicamentoHandler= new MensajeMedicamentoHandler();
    
    // @Autowired
    // MensajeRecordatorioHandler mensajeRecordatorioHandler = new MensajeRecordatorioHandler();
    //@Scheduled(fixedRate = 1000000)
//    public void executeJob() throws Exception {
//        solicitud.setMensaje(new Mensaje());
//        // Handler mensajeMedicamentoHandler=this.mensajeMedicamentoHandler;
//        // Handler mensajeRecordatorioHandler=this.mensajeRecordatorioHandler;
//        
//        // this.mensajeCitaNuevaHandler.SetNextHandler(mensajeRecordatorioHandler);
//        // this.mensajeRecordatorioHandler.SetNextHandler(mensajeMedicamentoHandler);
//        
//        
//        //id de prueba
//         List<Citas> citas = consultaService.buscarPorMedico();
//         LOG.info(citas.toString());
//         for (int i=0;i<citas.size();i++){
//            LOG.info("Enviando mensaje a "+citas.get(i).getTratamiento().getId_usuario().getNombre());     
//            
//            solicitud.setCita(citas.get(i));;
//            solicitud.getMensaje().setTipoMensaje(1);
//            mensaje.whatsapp(solicitud);
//            // mensaje.whatsapp(solicitud);
//            // Mensaje usuario= new Mensaje();
//            // usuario.setNumero("4281176295");
//            // usuario.setMensaje("4281176295");
//            // LOG.info("Inicio: " + new Date());
//          
//            // service.mensajeWhastapp(usuario);
//         }
//    }
}
