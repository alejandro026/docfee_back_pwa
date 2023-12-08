package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.EnfermedadesAntecedentes;
import com.docfee.admin.utng.repository.IEnfermedadesAntecedentesRepository;

@Service
public class EnfermedadesAntecedentesService implements IEnfermedadesAntecedentesService{

    @Autowired
    private IEnfermedadesAntecedentesRepository repository;
    
    @Override
    public List<EnfermedadesAntecedentes> consultarTodos() {
        List<EnfermedadesAntecedentes> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public EnfermedadesAntecedentes guardar(EnfermedadesAntecedentes model) {
        try {
            EnfermedadesAntecedentes regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new EnfermedadesAntecedentes();
        }
    }

    @Override
    public EnfermedadesAntecedentes actualizar(EnfermedadesAntecedentes model) {
        try {
            EnfermedadesAntecedentes regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new EnfermedadesAntecedentes();
        }
    }

    @Override
    public EnfermedadesAntecedentes eliminar(EnfermedadesAntecedentes model) {
        try {
            repository.delete(model);
            EnfermedadesAntecedentes regersa=model;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }

}
