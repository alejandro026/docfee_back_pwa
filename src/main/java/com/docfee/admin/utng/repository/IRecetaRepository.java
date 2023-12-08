package com.docfee.admin.utng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docfee.admin.utng.model.Citas;
import com.docfee.admin.utng.model.Receta;

public interface IRecetaRepository extends JpaRepository<Receta, Integer>{

	
	
	 @Query( value="SELECT tr.id_receta, tr.id_cita, tr.Diagnostico, tr.Edad, tr.Fecha, tr.Medicamento, tr.Horarios, tr.Tareas, tr.ProximaCita\r\n"
	 		+ "	FROM tb_recetas tr \r\n"
	 		+ "	inner join tb_citas tc on tr.id_cita = tc.id_cita \r\n"
	 		+ "	WHERE tr.id_cita = (:id) ", nativeQuery=true)
	    List<Receta> buscarPorCita(@Param("id") Integer id);
}
