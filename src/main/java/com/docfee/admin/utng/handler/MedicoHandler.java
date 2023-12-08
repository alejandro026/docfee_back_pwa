package com.docfee.admin.utng.handler;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Mensaje;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.service.IMedicoService;

@Service
public class MedicoHandler extends Handler{
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicoHandler.class);

    @Autowired
    IMedicoService medicoService;
//    @Autowired
//    sessionController session;
    
    @Override
    public LoginUsuario ProcessRequest(Solicitud request) {
        
        LoginUsuario medico= medicoService.loginUsuario(request);
                
        if(medico.getId()!=null) {
            LOGGER.error("Se encontro "+ medico.getNombre());
            request.setApproved(true);
            medico.setTipoUsuario("MEDICO");
            medico.setToken("2y3e892ye829");
            medico.setMensaje("Credenciales correctas");
            medico.setApproved(true);
//            try {
//                session.createSession(medico);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            return medico;
        }else {
            LOGGER.info("NO SE ENCONTRO --------------------Medico");
            medico.setMensaje("Usuario o contraseña incorrectas");
            return medico;
        }
    }

    @Override
    public void ProcesaRequestMensjae(Solicitud request) {
        // TODO Auto-generated method stub
    }

}
