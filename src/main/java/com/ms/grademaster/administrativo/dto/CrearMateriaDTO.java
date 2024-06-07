package com.ms.grademaster.administrativo.dto;

import com.ms.grademaster.comons.dto.CarreraDto;
import com.ms.grademaster.comons.dto.HorarioDTO;
import com.ms.grademaster.comons.dto.MateriaDto;
import com.ms.grademaster.comons.dto.SemestreDto;
import lombok.Data;

import java.util.List;

@Data
public class CrearMateriaDTO {

    private MateriaDto materia;

    private List<HorarioDTO> horarios;

    private SemestreDto semestre;

}
