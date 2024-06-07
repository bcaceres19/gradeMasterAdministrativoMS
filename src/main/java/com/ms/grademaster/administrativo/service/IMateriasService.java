package com.ms.grademaster.administrativo.service;

import com.ms.grademaster.comons.dto.*;
import com.ms.grademaster.comons.entity.CarreraEntity;

import java.util.List;

public interface IMateriasService {

    List<MateriaDto> getAllMaterias();

    List<MateriaDto> getMateriasInCarrera(Long idCarrera);

    void createCarreraMateria(CarreraEntity carrera, List<MateriaDto> materias);

    void crearMateria(MateriaDto materia, List<HorarioDTO> horarios, SemestreDto semestre);

}
