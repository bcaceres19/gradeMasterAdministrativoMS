package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity,String> {

    Boolean existsByCodigoEstudianteAndCedulaEstudiante(String codigoEstudiante, String cedulaEstudiante);


}
