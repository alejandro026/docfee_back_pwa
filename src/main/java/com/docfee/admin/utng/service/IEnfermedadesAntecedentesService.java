package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.EnfermedadesAntecedentes;


public interface IEnfermedadesAntecedentesService {
    public List<EnfermedadesAntecedentes> consultarTodos();
    
    public EnfermedadesAntecedentes guardar(EnfermedadesAntecedentes model);
    
    public EnfermedadesAntecedentes actualizar(EnfermedadesAntecedentes model);
    
    public EnfermedadesAntecedentes eliminar(EnfermedadesAntecedentes model);
}
