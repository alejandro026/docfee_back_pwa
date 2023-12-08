package com.docfee.admin.utng.handler;


import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Solicitud;
public abstract class Handler {
    
    protected Handler nextHandler;

    
    public void SetNextHandler(Handler NextHandler) {
        nextHandler = NextHandler;
    }

    public abstract LoginUsuario ProcessRequest(Solicitud request);
    
    public abstract void ProcesaRequestMensjae(Solicitud request);
}
