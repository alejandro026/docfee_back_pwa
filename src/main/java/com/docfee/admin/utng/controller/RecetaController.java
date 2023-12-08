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
import com.docfee.admin.utng.model.NuevaReceta;
import com.docfee.admin.utng.model.Receta;
import com.docfee.admin.utng.model.Tratamiento;
import com.docfee.admin.utng.service.IRecetaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private IRecetaService service;
    
    @GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Receta> consultartodos(){
        
        List<Receta> lista = service.consultarTodos();
        
        return lista;
        
    }
    
    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Receta guardar(@RequestBody NuevaReceta objeto){
        
        Receta objetoNuevo = service.guardar(objeto);
    	//NuevaReceta objetoNuevo= new NuevaReceta();
        return objetoNuevo;
        
    }
    
    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Receta actualizar(@RequestBody Receta objeto){
        
        Receta objetoActualizado = service.actualizar(objeto);
        
        return objetoActualizado;
        
    }
    
    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Receta eliminar(@RequestBody Receta objeto){
        
        Receta regresa = service.eliminar(objeto);
        
        return regresa;
        
    }
    @GetMapping(value = "/buscarPorId/{id}")
    public Receta buscarPorId(@PathVariable("id") Integer id) {
    	Receta regresa = service.buscarPorId(id);
        return regresa;
    }
    @GetMapping(value = "/buscarPorIdCita/{id}")
    public List<Receta> buscarPorIdCita(@PathVariable("id") Integer id) {
        List<Receta> regresa = service.buscarPorCita(id);
        return regresa;
    }
}
