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

import com.docfee.admin.utng.model.EnfermedadesAntecedentes;
import com.docfee.admin.utng.service.IEnfermedadesAntecedentesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/enfermedades/antecedentes")
public class EnfermedadesAntecedentesController {

    @Autowired
    private IEnfermedadesAntecedentesService service;
    
    @GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnfermedadesAntecedentes> consultartodos(){
        
        List<EnfermedadesAntecedentes> lista = service.consultarTodos();
        
        return lista;
        
    }
    
    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public EnfermedadesAntecedentes guardar(@RequestBody EnfermedadesAntecedentes objeto){
        
        EnfermedadesAntecedentes objetoNuevo = service.guardar(objeto);
        
        return objetoNuevo;
        
    }
    
    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public EnfermedadesAntecedentes actualizar(@RequestBody EnfermedadesAntecedentes objeto){
        
        EnfermedadesAntecedentes objetoActualizado = service.actualizar(objeto);
        
        return objetoActualizado;
        
    }
    
    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public EnfermedadesAntecedentes eliminar(@RequestBody EnfermedadesAntecedentes objeto){
        
        EnfermedadesAntecedentes regresa = service.eliminar(objeto);
        
        return regresa;
        
    }
}
