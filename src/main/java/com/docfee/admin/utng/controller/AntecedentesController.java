package com.docfee.admin.utng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docfee.admin.utng.model.Antecedentes;
import com.docfee.admin.utng.service.IAntecedentesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/antecedentes")
public class AntecedentesController {

    @Autowired
    private IAntecedentesService service;
    
    @GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Antecedentes> consultartodos(){
        
        List<Antecedentes> lista = service.consultarTodos();
        
        return lista;
        
    }
    
    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Antecedentes guardar(@RequestBody Antecedentes objeto){
        
        Antecedentes objetoNuevo = service.guardar(objeto);
        
        return objetoNuevo;
        
    }
    
    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Antecedentes actualizar(@RequestBody Antecedentes objeto){
        
        Antecedentes objetoActualizado = service.actualizar(objeto);
        
        return objetoActualizado;
        
    }
    
    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Antecedentes eliminar(@RequestBody Antecedentes objeto){
        
        Antecedentes regresa = service.eliminar(objeto);
        
        return regresa;
        
    }
}
