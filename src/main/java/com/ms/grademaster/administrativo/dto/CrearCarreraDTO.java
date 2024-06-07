package com.ms.grademaster.administrativo.dto;

import com.ms.grademaster.comons.dto.CarreraDto;
import com.ms.grademaster.comons.dto.MateriaDto;
import lombok.Data;

import java.util.List;

@Data
public class CrearCarreraDTO {

    private CarreraDto carrera;

    private List<MateriaDto> materias;

}
