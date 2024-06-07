package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.CarreraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity, String> {
}
