package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.controller.MensajeController;
import com.docfee.admin.utng.model.Citas;
import com.docfee.admin.utng.model.Medico;
import com.docfee.admin.utng.model.Mensaje;
import com.docfee.admin.utng.model.NuevaReceta;
import com.docfee.admin.utng.model.Receta;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.model.Tratamiento;
import com.docfee.admin.utng.repository.IRecetaRepository;

@Service
public class RecetaService implements IRecetaService{
	private static final Logger LOG = LoggerFactory.getLogger(RecetaService.class);
    @Autowired
    private IRecetaRepository repository;
    @Autowired
    private CitasService citasService;
    @Autowired
    private MensajeController mensajeCotroller;
    
    
    @Override
    public List<Receta> consultarTodos() {
        List<Receta> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public Receta guardar(NuevaReceta model) {
    	 LOG.info("Entro al metodo guaradar");
         
         Receta recetaGuadar= new Receta();

         Citas cita = citasService.buscarPorId(model.getId_cita());
        
         recetaGuadar.setDiagnostico(model.getDiagnostico());
         recetaGuadar.setMedicamento(model.getMedicamento());
         recetaGuadar.setFecha(model.getFecha());
         
         recetaGuadar.setId_cita(cita);
         recetaGuadar.setHorarios(model.getHorarios());
         recetaGuadar.setTareas(model.getTareas());
        
         
         Receta regresa= repository.save(recetaGuadar);

         
//             Solicitud solicitud = new Solicitud();
//             solicitud.setMensaje(new Mensaje());
//            solicitud.getMensaje().setTipoMensaje(2);
//             solicitud.getMensaje().setNombreMedico(cita.getId_medico().getNombre()+" " +cita.getId_medico().getApPaterno());
//             solicitud.setCita(cita);
//             solicitud.setReceta(regresa);
//             mensajeCotroller.whatsapp(solicitud);
             
               
        return regresa;
     }
    

    @Override
    public Receta actualizar(Receta model) {
        try {
            Receta regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Receta();
        }
    }

    @Override
    public Receta eliminar(Receta model) {
        try {
            repository.delete(model);
            Receta regersa=model;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }
    public Receta buscarPorId(Integer id) {
    	Receta receta = new Receta();
        Optional<Receta> op= repository.findById(id);
        
        if (op.isPresent()) {
        	receta=op.get();
        }
        
        return receta;
    }
    
    public List<Receta> buscarPorCita(Integer id) {
        try {
            List<Receta> lista= repository.buscarPorCita(id);
            return lista;
        } catch (Exception e) {
            return new ArrayList<Receta>();
        }
    }

}
