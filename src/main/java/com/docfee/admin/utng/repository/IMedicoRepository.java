package com.docfee.admin.utng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docfee.admin.utng.model.Medico;

public interface IMedicoRepository extends JpaRepository<Medico, Integer>{

    @Query(value=" SELECT id_usuario, Nombre, ApPaterno, ApMaterno, Nss, Telefono, id_UsuarioConfianza, sexo, FechaNac, correo, Ocupacion, id_antecedente, usuario, password\r\n"
            + "FROM docfee.tb_usuarios where docfee.tb_usuarios.usuario = :usuario and docfee.tb_usuarios.password =:password", nativeQuery=true)
    Medico loginBusqueda(@Param("usuario")String usuario, @Param("password") String password);
    
}
