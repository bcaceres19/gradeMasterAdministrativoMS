package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity, String> {

    Boolean existsByCodigoDocenteAndCedulaDocente(String codigoDocente, String cedulaDocente);

}
