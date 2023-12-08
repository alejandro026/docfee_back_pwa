package com.docfee.admin.utng.handler;
import java.util.concurrent.ExecutionException;

import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.docfee.admin.utng.controller.sessionController;
import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.service.IUsuarioService;
@Service
public class PacienteHandler extends Handler{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteHandler.class);

    
    @Autowired
    IUsuarioService usuarioService;
//    @Autowired
//    sessionController session;
     

    @Override
    public LoginUsuario ProcessRequest(Solicitud request) {
        LoginUsuario user= usuarioService.loginUsuario(request);
        
        LOGGER.info("eSTE ES EL USUARIO--------->"+user.getId());
        
        if(user.getId()!=null) {
            LOGGER.info("Se encontro ---------------------------->>"+ user.getNombre());
            request.setApproved(true);
            user.setTipoUsuario("PACIENTE");
            user.setToken("ywgdwiuh23782");
            user.setApproved(true);
            user.setMensaje("Credenciales correctas");
            // session sessionModel.setNombre(user.getNombre());
            // sessionModel.setId(Integer.parseInt(user.getId()));
            //LOGGER.info("Se encontro ---------------------------->>"+ sessionModel.toString());
//            try {
//                session.createSession(user);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            return user;
            
        }else if(request.isApproved()==false && nextHandler !=null) {
            LOGGER.error("NO se encontro---------Paciente");
            return nextHandler.ProcessRequest(request);
        }
        return user;
    }

    @Override
    public void ProcesaRequestMensjae(Solicitud request) {
        // TODO Auto-generated method stub
    }

}
