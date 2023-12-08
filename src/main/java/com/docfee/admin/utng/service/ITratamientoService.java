package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.dto.TratamientoDTO;
import com.docfee.admin.utng.model.DocumentoUpdate;
import com.docfee.admin.utng.model.Tratamiento;
import com.docfee.admin.utng.model.VistaTratamiento;


public interface ITratamientoService {
    public List<Tratamiento> consultarTodos();
    
    public Tratamiento guardar(TratamientoDTO model);
    
    public Tratamiento actualizar(TratamientoDTO model);
    
    public Tratamiento eliminar(Tratamiento model);
    
    public List<Tratamiento> buscarPorUsuario(Integer id);
    
    public Boolean actualizarDocumento(DocumentoUpdate objeto);
    
    public List<VistaTratamiento> vistaTratamientoIdUsuario(Integer id);
}
