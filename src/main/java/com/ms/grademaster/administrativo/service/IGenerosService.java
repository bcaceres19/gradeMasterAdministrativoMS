package com.ms.grademaster.administrativo.service;

import com.ms.grademaster.administrativo.dto.GenerosDTO;
import com.ms.grademaster.comons.utils.enums.GenerosEnum;

import java.util.List;

public interface IGenerosService {

    List<GenerosDTO> allGeneros();

}
