package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.MateriaHorarioEntity;
import com.ms.grademaster.comons.entity.MateriaHorarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaHorarioRepository extends JpaRepository<MateriaHorarioEntity, MateriaHorarioId> {
}
