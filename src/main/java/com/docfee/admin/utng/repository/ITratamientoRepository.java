package com.docfee.admin.utng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docfee.admin.utng.model.Tratamiento;

public interface ITratamientoRepository extends JpaRepository<Tratamiento, Integer>{

//    SELECT * FROM tr_tratamiento tt 
//    inner Join tb_usuarios tu on tt.Id_usuario = tu.id_usuario 
//    where tt.id_usuario =(:id)
    
    @Query( value=" SELECT tt.id_tratamiento, tt.Id_usuario, tt.id_medico, tt.Descripcion, tt.IPAS_SisTegumentario, tt.IPAS_SisMuscular, tt.IPAS_SisOseo, tt.IPAS_SisNervioso, tt.IPAS_SisEndocrino, tt.IPAS_SisInmunologico, tt.IPAS_SirCirculatorio, tt.IPAS_ApaUrinario, tt.IPAS_ApaRespiratorio, tt.IPAS_ApaDigestivo, tt.IPAS_ApaReproductor, tt.PresionArterial, tt.Frec_Cardiaca, tt.Frec_Respiratoria, tt.Temperaatura, tt.Altura, tt.IMC, tt.Aspectos_Generales, tt.DocumentosEstudios, tt.DiagnosticoPresuntivo, tt.TratamientoEmpleadoIntegral\r\n"
            + "FROM tr_tratamiento tt \r\n"
            + "inner Join tb_usuarios tu on tt.Id_usuario = tu.id_usuario \r\n"
            + "where tt.id_usuario =(:id)", nativeQuery=true)
    List<Tratamiento> buscarPorUsuario(@Param("id") Integer id);
}
