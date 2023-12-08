package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.CitaDTO;
import com.docfee.admin.utng.model.Citas;


public interface ICitasService {

    public List<Citas> consultarTodos();
    
    public Citas guardar(CitaDTO model);
    
    public Citas actualizar(Citas model);
    
    public Citas eliminar(Citas model);
}
