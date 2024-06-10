package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.SemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreRepository extends JpaRepository<SemestreEntity, Long> {

    @Query(value = """
        select  * FROM dbo.semestre s order by s.fecha_fin desc limit 1
    """, nativeQuery = true)
    List<Object[]> ultimoSemestre();

}
