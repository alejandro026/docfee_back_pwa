package com.docfee.admin.utng.service;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.LoginUsuario;
import com.docfee.admin.utng.model.Solicitud;
import com.docfee.admin.utng.model.Usuario;
import com.docfee.admin.utng.repository.IUsuariosRepository;

 
@Service
public class UsuarioService implements IUsuarioService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    
    @Autowired
    private IUsuariosRepository repository;
    
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private PushNotificationService pushService;

    @Override
    public List<Usuario> consultarTodos() {
        List<Usuario> lista= repository.findAllOrdenadoPorId();
        try {
            pushService.sendPushMessage();
        } catch (InterruptedException | ExecutionException | JoseException | GeneralSecurityException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(lista.isEmpty()) {
            return new ArrayList<>();
        }
        
        
        return lista;
    }

    @Override
    public Usuario guardar(Usuario user) {
        try {
            LOGGER.info("----------------------------------------<>");
            LOGGER.info(user.toString());
            Usuario userNew= repository.save(user);
            return userNew;
        } catch (Exception e) {
            return new Usuario();
        }
        
    }

    @Override
    public Usuario actualizar(Usuario user) {
        try {
//            Optional<Usuario> optinoal=repository.findById(user.getId_usuario());
//            Usuario usuarioActualizar= new Usuario();
//            if(!optinoal.isEmpty()) {
//                usuarioActualizar= optinoal.get();
//                usuarioActualizar.setApMaterno(null);
//                usuarioActualizar.setApPaterno(null);                
//            }
            
            Usuario userNew= repository.save(user);
            return userNew;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String eliminar(Usuario user) {
        try {
            repository.delete(user);
            String mensaje="Se elimino el usuario con el id "+user.getId_usuario();
            return mensaje;
        } catch (Exception e) {
            return "Error al eliminar el usuario";
        }
        
    }
    
    @Override
    public LoginUsuario loginUsuario(Solicitud request) {
//        List<Usuario> lista= repository.findAll();
        LoginUsuario loginUser= new LoginUsuario();
        Query q = entityManager.createNativeQuery("SELECT tu.id_usuario, (tu.Nombre || ' ' || tu.ApPaterno || ' ' || tu.ApMaterno) AS \"Nombre Completo\""
                + " FROM tb_usuarios as tu WHERE tu.usuario = :usuario");
        
        q.setParameter("usuario", request.getUsuario());
        
        List<Object[]> resutado = q.getResultList();
        LOGGER.info(resutado.toString());
        
        if(!resutado.isEmpty()) {
            for(Object[] datos: resutado) {
                loginUser.setId(datos[0]!=null ? datos[0].toString():"");
                loginUser.setNombre(datos[1]!=null ? datos[1].toString(): "");
            }
        }
        LOGGER.error("----------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>");
//        user= repository.loginBusqueda(request.getUsuario(), request.getPassword());
//        user=lista.get(0);
        LOGGER.info("------------------------------>>>>>>>>>>>>>>>>>>>>>>>>>>"+request.getUsuario() + "- "+ request.getPassword());
        return loginUser;
    }
    
    @Override
    public Usuario findById(Integer id) {
        Usuario regresa=new Usuario();
        try {
            Optional<Usuario> optional= repository.findById(id);
            
           
            
            if(optional.isPresent()) {
                regresa=optional.get();
            }
            
//            return regresa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regresa;
        
    }
    

}
