package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Medico;
import com.docfee.admin.utng.model.Solicitud;


public interface IMedicoService {
    public List<Medico> consultarTodos();
    
    public Medico guardar(Medico model);
    
    public Medico actualizar(Medico model);
    
    public Medico eliminar(Medico model);
    
    public LoginUsuario loginUsuario(Solicitud request);
    
    public Medico buscarPorId(Integer id);
}
