package com.docfee.admin.utng.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Medico;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.repository.IMedicoRepository;

@Service
public class MedicoService implements IMedicoService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);


    @Autowired
    private IMedicoRepository repository;
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Medico> consultarTodos() {
        List<Medico> lista= repository.findAll();
        
        if(lista.isEmpty()) {
            return new ArrayList<>();
        } 
        return lista;
    }

    @Override
    public Medico guardar(Medico model) {
        try {
            Medico regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Medico();
        }
    }

    @Override
    public Medico actualizar(Medico model) {
        try {
            Medico regresa= repository.save(model);
            return regresa;
        } catch (Exception e) {
            return new Medico();
        }
    }

    @Override
    public Medico eliminar(Medico model) {
        try {
            repository.delete(model);
            Medico regersa=model;
            return regersa;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public LoginUsuario loginUsuario(Solicitud request) {
        LoginUsuario loginUser= new LoginUsuario();
        Query q = entityManager.createNativeQuery("SELECT Id_medico, (tm.Nombre || ' ' || tm.ApPaterno || ' ' || tm.ApMaterno) AS \"Nombre Completo\""
                + " FROM tb_medicos tm WHERE tm.usuario = :usuario");

        
        q.setParameter("usuario", request.getUsuario());
//        q.setParameter("password", request.getPassword());
        
        List<Object[]> resutado = q.getResultList();
        
        if(!resutado.isEmpty()) {
            for(Object[] datos: resutado) {
                loginUser.setId(datos[0]!=null ? datos[0].toString():"");
                loginUser.setNombre(datos[1]!=null ? datos[1].toString(): "");
            }
        }
        LOGGER.error("----------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>");
//        user= repository.loginBusqueda(request.getUsuario(), request.getPassword());
//        user=lista.get(0);
        LOGGER.error("----------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>");
        return loginUser;
    }

    @Override
    public Medico buscarPorId(Integer id) {
        Optional<Medico> optional = repository.findById(id);
        Medico medico=null;
        
        if(optional.isPresent()) {
            medico=optional.get();
        }
        return medico;
    }
    
}
