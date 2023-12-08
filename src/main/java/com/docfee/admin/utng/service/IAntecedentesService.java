package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.Antecedentes;

public interface IAntecedentesService {

    public List<Antecedentes> consultarTodos();
    
    public Antecedentes guardar(Antecedentes model);
    
    public Antecedentes actualizar(Antecedentes model);
    
    public Antecedentes eliminar(Antecedentes model);
}
