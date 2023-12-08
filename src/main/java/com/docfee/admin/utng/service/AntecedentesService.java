package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.Antecedentes;
import com.docfee.admin.utng.repository.IAntecedentesRepository;

@Service
public class AntecedentesService implements IAntecedentesService{
    
    @Autowired
    private IAntecedentesRepository repository;

    @Override
    public List<Antecedentes> consultarTodos() {
        List<Antecedentes> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public Antecedentes guardar(Antecedentes model) {
        try {
            Antecedentes regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Antecedentes();
        }
    }

    @Override
    public Antecedentes actualizar(Antecedentes model) {
        try {
            Antecedentes regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Antecedentes();
        }
    }

    @Override
    public Antecedentes eliminar(Antecedentes user) {
        try {
            repository.delete(user);
            Antecedentes regersa=user;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }

    
}
