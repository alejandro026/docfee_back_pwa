package com.docfee.admin.utng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.docfee.admin.utng.model.Citas;

public interface ICitasRepository extends JpaRepository<Citas, Integer>{
    
    @Query( value="SELECT tbc.id_cita, tbc.id_medico, tbc.Fecha, tbc.Lugar, tbc.Especialidad, tbc.Notas, tbc.id_tratamiento, tbc.confirmada\r\n"
            + "FROM tb_citas tbc\r\n"
            + "INNER JOIN tr_tratamiento tt on tbc.id_tratamiento = tt.id_tratamiento \r\n"
            + "WHERE  tbc.id_tratamiento = (:id) ORDER BY tbc.id_cita DESC", nativeQuery=true)
    List<Citas> buscarPorTramiento(@Param("id") Integer id);
    
    @Query( value="SELECT tbc.id_cita, tbc.id_medico, tbc.Fecha, tbc.Lugar, tbc.Especialidad, tbc.Notas, tbc.id_tratamiento, tbc.confirmada\r\n"
            + "FROM tb_citas tbc\r\n"
            + "INNER JOIN tr_tratamiento tt on tbc.id_tratamiento = tt.id_tratamiento \r\n"
            + "WHERE  tt.Id_usuario = (:id)  AND tbc.Fecha > NOW() and tbc.confirmada =1 ORDER BY tbc.id_cita DESC", nativeQuery=true)
    List<Citas> buscarPorUsuario(@Param("id") Integer id);

    @Query( value="SELECT tbc.id_cita, tbc.id_medico, tbc.Fecha, tbc.Lugar, tbc.Especialidad, tbc.Notas, tbc.id_tratamiento, tbc.confirmada\r\n"
            + " FROM tb_citas tbc \r\n"
            + " where tbc.id_medico =:id  AND tbc.Fecha > NOW() and tbc.confirmada =1 ORDER BY tbc.id_cita DESC", nativeQuery=true)
    List<Citas> buscarPorMedicoFecha(@Param("id") Integer id); 
    
    @Transactional
    @Modifying
    @Query( value="UPDATE tb_citas "
            + "SET confirmada=:estatus "
            + "WHERE id_cita=:id ; "
            + "", nativeQuery=true)
    void actualizaEstatus(@Param("id") Integer id, @Param("estatus") Integer estatus);
}
