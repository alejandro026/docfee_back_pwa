package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docfee.admin.utng.dto.TratamientoDTO;
import com.docfee.admin.utng.model.DocumentoUpdate;
import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Tratamiento;
import com.docfee.admin.utng.model.Usuario;
import com.docfee.admin.utng.model.VistaTratamiento;
import com.docfee.admin.utng.repository.ITratamientoRepository;
import com.docfee.admin.utng.repository.IUsuariosRepository;

@Service
public class TratamientoService implements ITratamientoService{
    
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private IUsuariosRepository usuarioRepository;
    

    @Autowired
    private ITratamientoRepository repository;
    @Override
    public List<Tratamiento> consultarTodos() {
        List<Tratamiento> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public Tratamiento guardar(TratamientoDTO model) {
        try {
            Optional<Usuario> optinoal= usuarioRepository.findById(model.getId_usuario());
            Tratamiento tratamientoNuevo= new Tratamiento();

            if(optinoal.isPresent()) {
                tratamientoNuevo.setAltura(model.getAltura());
                tratamientoNuevo.setAspectos_Generales(model.getAspectos_Generales());
                tratamientoNuevo.setDescripcion(model.getDescripcion());
                tratamientoNuevo.setDiagnosticoPresuntivo(model.getDiagnosticoPresuntivo());
                tratamientoNuevo.setDocumentosEstudios(model.getDocumentosEstudios());
                tratamientoNuevo.setFrec_Cardiaca(model.getFrec_Cardiaca());
                tratamientoNuevo.setFrec_Respiratoria(model.getFrec_Respiratoria());
                tratamientoNuevo.setId_medico(model.getId_medico());
                tratamientoNuevo.setId_usuario(optinoal.get());
                tratamientoNuevo.setImc(model.getImc());
                tratamientoNuevo.setIPAS_ApaDigestivo(model.getIPAS_ApaDigestivo());
                tratamientoNuevo.setIPAS_ApaReproductor(model.getIPAS_ApaDigestivo());
                tratamientoNuevo.setIPAS_ApaRespiratorio(model.getIPAS_ApaRespiratorio());
                tratamientoNuevo.setIPAS_ApaUrinario(model.getIPAS_ApaUrinario());
                tratamientoNuevo.setIPAS_SirCirculatorio(model.getIPAS_SirCirculatorio());
                tratamientoNuevo.setIPAS_SisEndocrino(model.getIPAS_SisEndocrino());
                tratamientoNuevo.setIPAS_SisInmunologico(model.getIPAS_SisInmunologico());
                tratamientoNuevo.setIPAS_SisMuscular(model.getIPAS_SisMuscular());
                tratamientoNuevo.setIPAS_SisNervioso(model.getIPAS_SisNervioso());
                tratamientoNuevo.setIPAS_SisOseo(model.getIPAS_SisOseo());
                tratamientoNuevo.setIPAS_SisTegumentario(model.getIPAS_SisTegumentario());
                tratamientoNuevo.setPresionArterial(model.getPresionArterial());
                tratamientoNuevo.setTemperaatura(model.getTemperaatura());
                tratamientoNuevo.setTratamientoEmpleadoIntegral(model.getTratamientoEmpleadoIntegral());
            }
            
            Tratamiento regresa= repository.save(tratamientoNuevo);
            return regresa;
        } catch (Exception e) {
            return new Tratamiento();
        }
    }

    @Override
    public Tratamiento actualizar(TratamientoDTO model) {
        try {
            Optional<Usuario> optinoal= usuarioRepository.findById(model.getId_usuario());
            Tratamiento tratamientoNuevo= new Tratamiento();

            if(optinoal.isPresent()) {
                tratamientoNuevo.setId_tratamiento(model.getId_tratamiento());
                tratamientoNuevo.setAltura(model.getAltura());
                tratamientoNuevo.setAspectos_Generales(model.getAspectos_Generales());
                tratamientoNuevo.setDescripcion(model.getDescripcion());
                tratamientoNuevo.setDiagnosticoPresuntivo(model.getDiagnosticoPresuntivo());
                tratamientoNuevo.setDocumentosEstudios(model.getDocumentosEstudios());
                tratamientoNuevo.setFrec_Cardiaca(model.getFrec_Cardiaca());
                tratamientoNuevo.setFrec_Respiratoria(model.getFrec_Respiratoria());
                tratamientoNuevo.setId_medico(model.getId_medico());
                tratamientoNuevo.setId_usuario(optinoal.get());
                tratamientoNuevo.setImc(model.getImc());
                tratamientoNuevo.setIPAS_ApaDigestivo(model.getIPAS_ApaDigestivo());
                tratamientoNuevo.setIPAS_ApaReproductor(model.getIPAS_ApaDigestivo());
                tratamientoNuevo.setIPAS_ApaRespiratorio(model.getIPAS_ApaRespiratorio());
                tratamientoNuevo.setIPAS_ApaUrinario(model.getIPAS_ApaUrinario());
                tratamientoNuevo.setIPAS_SirCirculatorio(model.getIPAS_SirCirculatorio());
                tratamientoNuevo.setIPAS_SisEndocrino(model.getIPAS_SisEndocrino());
                tratamientoNuevo.setIPAS_SisInmunologico(model.getIPAS_SisInmunologico());
                tratamientoNuevo.setIPAS_SisMuscular(model.getIPAS_SisMuscular());
                tratamientoNuevo.setIPAS_SisNervioso(model.getIPAS_SisNervioso());
                tratamientoNuevo.setIPAS_SisOseo(model.getIPAS_SisOseo());
                tratamientoNuevo.setIPAS_SisTegumentario(model.getIPAS_SisTegumentario());
                tratamientoNuevo.setPresionArterial(model.getPresionArterial());
                tratamientoNuevo.setTemperaatura(model.getTemperaatura());
                tratamientoNuevo.setTratamientoEmpleadoIntegral(model.getTratamientoEmpleadoIntegral());
            }
            
            
            Tratamiento regresa= repository.save(tratamientoNuevo);
            return regresa;
        } catch (Exception e) {
            return new Tratamiento();
        }
    }

    @Override
    public Tratamiento eliminar(Tratamiento model) {
        try {
            repository.delete(model);
            Tratamiento regersa=model;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<VistaTratamiento> vistaTratamiento(Integer id){


        List<VistaTratamiento> lista= new ArrayList<VistaTratamiento>();
        
        Query q = entityManager.createNativeQuery("SELECT id_tratamiento, id_usuario, \"Nombre Completo\", Descripcion, Aspectos_Generales, DiagnosticoPresuntivo, TratamientoEmpleadoIntegral, id_antecedente"
                + " FROM v_Expedientes WHERE id_usuario = (:id);");

        q.setParameter("id", id);
        List<Object[]> resultado = q.getResultList();

        
        if (!resultado.isEmpty()) {
            for (Object[] datos : resultado) {
                VistaTratamiento item = new VistaTratamiento();
                item.setId_tratamiento(Integer.valueOf(datos[0]!=null ? datos[0].toString(): ""));
                item.setId_usuario(Integer.valueOf(datos[1].toString()));
                item.setNombre_completo(datos[2]!=null?datos[2].toString():"");
                if(datos[3]==null) {
                    item.setDescripcion("");
                }else {
                    item.setDescripcion(datos[3].toString());
                }
                item.setAspectos_generales(datos[4]!=null?datos[4].toString():"");
                item.setDiagnostico_presuntivo(datos[5]!=null?datos[5].toString():"");
                item.setTratamiento_integral(datos[6]!=null?datos[6].toString():"");
                item.setId_antecedentes(Integer.valueOf(datos[7].toString()));
                lista.add(item);
            }
        }
        return lista;
               
    }
    
    public List<VistaTratamiento> vistaTratamientoDR(){


        List<VistaTratamiento> lista= new ArrayList<VistaTratamiento>();
//        
//        Query q = entityManager.createNativeQuery("SELECT id_tratamiento, id_usuario, `Nombre Completo`, Descripcion, Aspectos_Generales, DiagnosticoPresuntivo, TratamientoEmpleadoIntegral, id_antecedente "
//                + "FROM v_Expedientes");
        
        Query q = entityManager.createNativeQuery("SELECT id_tratamiento, id_usuario, \"Nombre Completo\", Descripcion, Aspectos_Generales, DiagnosticoPresuntivo, TratamientoEmpleadoIntegral, id_antecedente "
                + "FROM v_Expedientes");

        
        List<Object[]> resultado = q.getResultList();

        
        if (!resultado.isEmpty()) {
            for (Object[] datos : resultado) {
                VistaTratamiento item = new VistaTratamiento();
                item.setId_tratamiento(Integer.valueOf(datos[0]!=null ? datos[0].toString(): ""));
                item.setId_usuario(Integer.valueOf(datos[1].toString()));
                item.setNombre_completo(datos[2]!=null?datos[2].toString():"");
                if(datos[3]==null) {
                    item.setDescripcion("");
                }else {
                    item.setDescripcion(datos[3].toString());
                }
                item.setAspectos_generales(datos[4]!=null?datos[4].toString():"");
                item.setDiagnostico_presuntivo(datos[5]!=null?datos[5].toString():"");
                item.setTratamiento_integral(datos[6]!=null?datos[6].toString():"");
                item.setId_antecedentes(Integer.valueOf(datos[7].toString()));
                lista.add(item);
            }
        }
        return lista;
               
    }

    @Override
    public List<VistaTratamiento> vistaTratamientoIdUsuario(Integer id){
        List<VistaTratamiento> lista= new ArrayList<VistaTratamiento>();
        
        Query q = entityManager.createNativeQuery("SELECT id_tratamiento, id_usuario, \"Nombre Completo\", Descripcion, Aspectos_Generales, DiagnosticoPresuntivo, TratamientoEmpleadoIntegral, id_antecedente"
                + " FROM v_Expedientes WHERE id_usuario = (:id_usuario)");

        q.setParameter("id_usuario", id);
        
        List<Object[]> resultado = q.getResultList();

        
        if (!resultado.isEmpty()) {
            for (Object[] datos : resultado) {
                VistaTratamiento item = new VistaTratamiento();
                item.setId_tratamiento(Integer.valueOf(datos[0]!=null ? datos[0].toString(): ""));
                item.setId_usuario(Integer.valueOf(datos[1].toString()));
                item.setNombre_completo(datos[2]!=null?datos[2].toString():"");
                if(datos[3]==null) {
                    item.setDescripcion("");
                }else {
                    item.setDescripcion(datos[3].toString());
                }
                item.setAspectos_generales(datos[4]!=null?datos[4].toString():"");
                item.setDiagnostico_presuntivo(datos[5]!=null?datos[5].toString():"");
                item.setTratamiento_integral(datos[6]!=null?datos[6].toString():"");
                item.setId_antecedentes(Integer.valueOf(datos[7].toString()));
                lista.add(item);
            }
        }
        return lista;
               
    }
    

    public Tratamiento buscarPorId(Integer id) {
        Tratamiento tratamiento = new Tratamiento();
        Optional<Tratamiento> op= repository.findById(id);
        
        if (op.isPresent()) {
            tratamiento=op.get();
        }
        
        return tratamiento;
    }

    @Override
    public List<Tratamiento> buscarPorUsuario(Integer id) {
        try {
            List<Tratamiento> lista= repository.buscarPorUsuario(id);
            return lista;
        } catch (Exception e) {
            return new ArrayList<Tratamiento>();
        }
    }
    
    @Override
    @Transactional
    public Boolean actualizarDocumento(DocumentoUpdate objeto){
        
        Query q = entityManager.createNativeQuery("UPDATE docfee.tr_tratamiento"
                + " SET DocumentosEstudios = (:ruta)"
                + " WHERE Id_usuario = (:id)");

        
         q.setParameter("ruta",objeto.getRuta());
         q.setParameter("id", objeto.getId());
       
         Integer resultado= q.executeUpdate();

        if(resultado==1) {
            return true;
        };
        
        return false;
               
    }
    

}
