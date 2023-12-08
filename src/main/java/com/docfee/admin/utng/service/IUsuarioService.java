package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.model.Usuario;

public interface IUsuarioService {
    public List<Usuario> consultarTodos();
    
    public Usuario guardar(Usuario user);
    
    public Usuario actualizar(Usuario user);
    
    public String eliminar(Usuario user);
    
    public LoginUsuario loginUsuario(Solicitud request);

    Usuario findById(Integer id);
}
