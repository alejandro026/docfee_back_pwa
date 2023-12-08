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

import com.docfee.admin.utng.model.CitaDTO;
import com.docfee.admin.utng.model.Citas;
import com.docfee.admin.utng.service.CitasService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasService service;
    

    @GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Citas> consultartodos(){
        
        List<Citas> lista = service.consultarTodos();
        
        return lista;
        
    }
    
    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Citas guardar(@RequestBody CitaDTO objeto){
        
        Citas objetoNuevo = service.guardar(objeto);
//        CitaDTO objetoNuevo= new CitaDTO();
        
        return objetoNuevo;
        
    }
    
    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Citas actualizar(@RequestBody Citas objeto){
        
        Citas objetoActualizado = service.actualizar(objeto);
        
        return objetoActualizado;
        
    }
    
    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Citas eliminar(@RequestBody Citas objeto){
        
        Citas regresa = service.eliminar(objeto);
        
        return regresa;
        
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public List<Citas> buscarPorId(@PathVariable("id") Integer id) {
        List<Citas> regresa = service.buscarPorTramiento(id);
        return regresa;
    }
    
    @GetMapping(value = "/buscarPorIdUsuario/{id}")
    public List<Citas> buscarPorIdUsuario(@PathVariable("id") Integer id) {
        List<Citas> regresa = service.buscarPorUsuario(id);
        return regresa;
    }

    @GetMapping(value = "/buscarPorIdMedico/{id}")
    public List<Citas> buscarPorIdMedico(@PathVariable("id") Integer id) {
        List<Citas> regresa = service.buscarPorMedico(id);
        return regresa;
    }
    
    @GetMapping(value = "/actualizaEstatus/{id}/{estatus}")
    public void actualizaEstatus(@PathVariable("id") Integer id, @PathVariable("estatus") Integer estatus) {
        service.actualizaEstatus(id, estatus);
    }
}
