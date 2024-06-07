package com.ms.grademaster.administrativo.service;

import com.ms.grademaster.comons.dto.SemestreDto;

import java.util.List;

public interface ISemestreService {

    Boolean semestreVencido();

    SemestreDto getUltimoSemestre();

}
