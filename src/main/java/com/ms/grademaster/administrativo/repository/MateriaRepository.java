package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, String> {
}
