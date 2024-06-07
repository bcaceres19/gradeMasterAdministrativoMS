package com.ms.grademaster.administrativo.repository;

import com.ms.grademaster.comons.entity.AdministrativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepository extends JpaRepository<AdministrativoEntity, Integer> {

    Boolean existsByCodigoAdministrativoAndCedulaAdministrativo(String codigoAdministrativo, String cedulaAdministrativo);

    AdministrativoEntity findByCodigoAdministrativo(String codigoAdministrativo);

}
