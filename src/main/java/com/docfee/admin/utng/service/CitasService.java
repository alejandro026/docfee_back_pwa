package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.controller.MensajeController;
import com.docfee.admin.utng.model.CitaDTO;
import com.docfee.admin.utng.model.Citas;
import com.docfee.admin.utng.model.Medico;
import com.docfee.admin.utng.model.Mensaje;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.model.Tratamiento;
import com.docfee.admin.utng.repository.ICitasRepository;

@Service
public class CitasService implements ICitasService{

    private static final Logger LOG = LoggerFactory.getLogger(CitasService.class);


    @Autowired
    private ICitasRepository repository;

    @Autowired
    private TratamientoService tratamientoService;
    
    @Autowired
    private IMedicoService medicoService;
    
    @Autowired
    private MensajeController mensajeCotroller;
    
    @Override
    public List<Citas> consultarTodos() {
        List<Citas> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public Citas guardar(CitaDTO model) {
        
        LOG.info("Entro al metodo guaradar");
        
        Citas citaGuadar= new Citas();

        Medico medico = medicoService.buscarPorId(model.getId_medico());
        
        Tratamiento tratamiento= tratamientoService.buscarPorId(model.getTratamiento());
        
        citaGuadar.setEspecialidad(model.getEspecialidad());
        citaGuadar.setFecha(model.getFecha());
        
        citaGuadar.setId_medico(medico);
        citaGuadar.setLugar(model.getLugar());
        citaGuadar.setNotas(model.getNotas());
        citaGuadar.setTratamiento(tratamiento);
        citaGuadar.setConfirmada(model.getConfirmada());
        
        Citas regresa= repository.save(citaGuadar);

        
//            Solicitud solicitud = new Solicitud();
//            solicitud.setMensaje(new Mensaje());
//            solicitud.getMensaje().setTipoMensaje(0);
//            solicitud.getMensaje().setNombreMedico(medico.getNombre()+" "+medico.getApPaterno());
//            solicitud.setCita(regresa);
//            mensajeCotroller.whatsapp(solicitud);
            
              
       return regresa;
    }

    @Override
    public Citas actualizar(Citas model) {
        try {
            Citas regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Citas();
        }
    }

    @Override
    public Citas eliminar(Citas model) {
        try {
            repository.delete(model);
            Citas regersa=model;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }

    public Citas buscarPorId(Integer id) {
        Citas citas = new Citas();
        Optional<Citas> op= repository.findById(id);
        
        if (op.isPresent()) {
            citas=op.get();
        }
        
        return citas;
    }
    
    public List<Citas> buscarPorTramiento(Integer id) {
        try {
            List<Citas> lista= repository.buscarPorTramiento(id);
            return lista;
        } catch (Exception e) {
            return new ArrayList<Citas>();
        }
    }
    
    public List<Citas> buscarPorUsuario(Integer id) {
        try {
            List<Citas> lista= repository.buscarPorUsuario(id);
            return lista;
        } catch (Exception e) {
            return new ArrayList<Citas>();
        }
    }

    public List<Citas> buscarPorMedico(Integer id) {
        try {
            List<Citas> lista= repository.buscarPorMedicoFecha(id);
            return lista;
        } catch (Exception e) {
            return new ArrayList<Citas>();
        }
    }
    
    public void actualizaEstatus(Integer id, Integer estatus) {
        repository.actualizaEstatus(id, estatus);
    }

}
