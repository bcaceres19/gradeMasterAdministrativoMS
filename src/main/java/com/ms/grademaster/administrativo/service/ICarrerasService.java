package com.ms.grademaster.administrativo.service;

import com.ms.grademaster.comons.dto.CarreraDto;
import com.ms.grademaster.comons.dto.MateriaDto;

import java.util.List;

public interface ICarrerasService {

    List<CarreraDto>  consultarCarreras();

    void crearCarrera(CarreraDto carreraDto,List<MateriaDto> materias);

}
