package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.NuevaReceta;
import com.docfee.admin.utng.model.Receta;


public interface IRecetaService {
    public List<Receta> consultarTodos();
    
    public Receta guardar(NuevaReceta model);
    
    public Receta actualizar(Receta model);
    
    public Receta eliminar(Receta model);
    
    public Receta buscarPorId(Integer id);
    
    public List<Receta> buscarPorCita(Integer id);
}
