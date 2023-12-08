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

import com.docfee.admin.utng.model.Enfermedades;
import com.docfee.admin.utng.service.IEnfermedadesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/enfermedades")
public class EnfermedadesController {

    @Autowired
    private IEnfermedadesService service;
    
    @GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Enfermedades> consultartodos(){
        
        List<Enfermedades> lista = service.consultarTodos();
        
        return lista;
        
    }
    
    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Enfermedades guardar(@RequestBody Enfermedades objeto){
        
        Enfermedades objetoNuevo = service.guardar(objeto);
        
        return objetoNuevo;
        
    }
    
    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Enfermedades actualizar(@RequestBody Enfermedades objeto){
        
        Enfermedades objetoActualizado = service.actualizar(objeto);
        
        return objetoActualizado;
        
    }
    
    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Enfermedades eliminar(@RequestBody Enfermedades objeto){
        
        Enfermedades regresa = service.eliminar(objeto);
        
        return regresa;
        
    }
}
