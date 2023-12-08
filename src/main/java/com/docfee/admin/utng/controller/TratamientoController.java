package com.docfee.admin.utng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docfee.admin.utng.dto.TratamientoDTO;
import com.docfee.admin.utng.model.DocumentoUpdate;
import com.docfee.admin.utng.model.Tratamiento;
import com.docfee.admin.utng.model.VistaTratamiento;
import com.docfee.admin.utng.service.TratamientoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService service;
    

    @GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tratamiento> consultartodos(){
        
        List<Tratamiento> lista = service.consultarTodos();
        
        return lista;
        
    }
    
    // @GetMapping(value = "/buscarPorUsuario/{id}")
    // public List<Tratamiento> buscarPorUsuario(@PathVariable("id") Integer id) {
    //     List<Tratamiento> regresa = service.buscarPorUsuario(id);
    //     return regresa;
    // }

    @GetMapping(path = "/consultarTodosVista/{id}")
    public List<VistaTratamiento> consultartodosVista(@PathVariable("id") Integer id){
        
        List<VistaTratamiento> lista = service.vistaTratamiento(id);
        
        return lista;
        
    }
    
    @GetMapping(path = "/consultarTodosVistaIdUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VistaTratamiento> consultartodosVistaIdUsuario(@PathVariable("id") Integer id){
        
        List<VistaTratamiento> lista = service.vistaTratamientoIdUsuario(id);
        
        return lista;
        
    }
    
    

    @GetMapping(path = "/consultarTodosVistaDR", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<VistaTratamiento> consultartodosVistaDR(){
        
        List<VistaTratamiento> lista = service.vistaTratamientoDR();
        
        return lista;
        
    }

    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tratamiento guardar(@RequestBody TratamientoDTO objeto){
        
        Tratamiento objetoNuevo = service.guardar(objeto);
        
        return objetoNuevo;
        
    }
    
    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tratamiento actualizar(@RequestBody TratamientoDTO objeto){
        
        Tratamiento objetoActualizado = service.actualizar(objeto);
        
        return objetoActualizado;
        
    }
    
    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tratamiento eliminar(@RequestBody Tratamiento objeto){
        
        Tratamiento regresa = service.eliminar(objeto);
        
        return regresa;
        
    }
    
    @GetMapping(value = "/buscarPorId/{id}")
    public Tratamiento buscarPorId(@PathVariable("id") Integer id) {
        Tratamiento regresa = service.buscarPorId(id);
        return regresa;
    }
    
    @GetMapping(value = "/buscarPorUsuario/{id}")
    public List<Tratamiento> buscarPorUsuario(@PathVariable("id") Integer id) {
        List<Tratamiento> regresa = service.buscarPorUsuario(id);
        return regresa;
    }
    
    @PostMapping(path = "/actualizarDocumento", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean actualizarDocumento(@RequestBody DocumentoUpdate objeto){
        
        Boolean regresa = service.actualizarDocumento(objeto);
        
        return regresa;
        
    }
    
    
}
