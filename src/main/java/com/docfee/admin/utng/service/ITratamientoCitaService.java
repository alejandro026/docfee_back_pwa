package com.docfee.admin.utng.service;

import java.util.List;

import com.docfee.admin.utng.model.TratamientoCita;


public interface ITratamientoCitaService {

    public List<TratamientoCita> consultarTodos();
    
    public TratamientoCita guardar(TratamientoCita model);
    
    public TratamientoCita actualizar(TratamientoCita model);
    
    public TratamientoCita eliminar(TratamientoCita model);
}
