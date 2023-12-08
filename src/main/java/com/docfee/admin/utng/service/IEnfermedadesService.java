package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.Enfermedades;


public interface IEnfermedadesService {

    public List<Enfermedades> consultarTodos();
    
    public Enfermedades guardar(Enfermedades model);
    
    public Enfermedades actualizar(Enfermedades model);
    
    public Enfermedades eliminar(Enfermedades model);
}
