package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.CarreraEntity;
import com.ms.grademaster.comons.entity.CarreraMateriaEntity;
import com.ms.grademaster.comons.entity.CarreraMateriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface MateriaCarrearRepository extends JpaRepository<CarreraMateriaEntity, CarreraMateriaId> {

    @Query(value = """
      SELECT m.codigo,m.nombre, m.ncreditos,e.nombre  FROM CarreraMateria cm
      JOIN Materia m  ON m.codigo = cm.codigo_materia_fk
      JOIN Estado e ON m.estado_fk = e.id_estado
      WHERE cm.codigo_carrera_fk = :idCarrera
    """, nativeQuery = true)
    List<Object[]> findAllMateriasByIdCarrera(@Param("idCarrera") Long idCarrera);

}
