package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.Enfermedades;
import com.docfee.admin.utng.repository.IEnfermedadesRepository;

@Service
public class EnfermedadesService implements IEnfermedadesService{

    @Autowired
    private IEnfermedadesRepository repository;
    
    @Override
    public List<Enfermedades> consultarTodos() {
        List<Enfermedades> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public Enfermedades guardar(Enfermedades model) {
        try {
            Enfermedades regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Enfermedades();
        }
    }

    @Override
    public Enfermedades actualizar(Enfermedades model) {
        try {
            Enfermedades regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Enfermedades();
        }
    }

    @Override
    public Enfermedades eliminar(Enfermedades model) {
        try {
            repository.delete(model);
            Enfermedades regersa=model;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }

}
