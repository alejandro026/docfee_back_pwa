package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.TratamientoCita;
import com.docfee.admin.utng.repository.ITratamientoCitaRepository;

@Service
public class TratamientoCitaService implements ITratamientoCitaService{

    @Autowired
    private ITratamientoCitaRepository repository;
    @Override
    public List<TratamientoCita> consultarTodos() {
        List<TratamientoCita> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public TratamientoCita guardar(TratamientoCita model) {
        try {
            TratamientoCita regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new TratamientoCita();
        }
    }

    @Override
    public TratamientoCita actualizar(TratamientoCita model) {
        try {
            TratamientoCita regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new TratamientoCita();
        }
    }

    @Override
    public TratamientoCita eliminar(TratamientoCita model) {
        try {
            repository.delete(model);
            TratamientoCita regersa=model;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }


}
