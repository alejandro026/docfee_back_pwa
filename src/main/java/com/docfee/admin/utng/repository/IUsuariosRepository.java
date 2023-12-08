package com.docfee.admin.utng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docfee.admin.utng.model.Usuario;

public interface IUsuariosRepository extends JpaRepository<Usuario, Integer>{
    List<Usuario> findByApMaterno(String apMaterno);
    
    @Query("SELECT u FROM Usuario u ORDER BY u.id_usuario DESC")
    List<Usuario> findAllOrdenadoPorId();

    
    @Query(value="SELECT Id_medico, Nombre, ApPaterno, ApMaterno, CedulaProfesional, Telefono, usuario, password\r\n"
            + "FROM docfee.tb_medicos where docfee.tb_medicos.usuario = :usuario and docfee.tb_medicos.password =:password", nativeQuery=true)
    Usuario loginBusqueda(@Param("usuario")String usuario, @Param("password") String password);
}
