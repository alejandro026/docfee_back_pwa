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

import com.docfee.admin.utng.model.TratamientoCita;
import com.docfee.admin.utng.service.ITratamientoCitaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tratamientocita")
public class TratamientoCitaController {

    @Autowired
    private ITratamientoCitaService service;
    
    @GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TratamientoCita> consultartodos(){
        
        List<TratamientoCita> lista = service.consultarTodos();
        
        return lista;
        
    }
    
    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public TratamientoCita guardar(@RequestBody TratamientoCita objeto){
        
        TratamientoCita objetoNuevo = service.guardar(objeto);
        
        return objetoNuevo;
        
    }
    
    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public TratamientoCita actualizar(@RequestBody TratamientoCita objeto){
        
        TratamientoCita objetoActualizado = service.actualizar(objeto);
        
        return objetoActualizado;
        
    }
    
    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public TratamientoCita eliminar(@RequestBody TratamientoCita objeto){
        
        TratamientoCita regresa = service.eliminar(objeto);
        
        return regresa;
        
    }
}
