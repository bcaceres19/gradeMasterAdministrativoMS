package com.ms.grademaster.administrativo.service.impl;

import com.ms.grademaster.administrativo.repository.EstadoRepository;
import com.ms.grademaster.administrativo.repository.MateriaCarrearRepository;
import com.ms.grademaster.administrativo.repository.MateriaHorarioRepository;
import com.ms.grademaster.administrativo.repository.MateriaRepository;
import com.ms.grademaster.administrativo.service.IMateriasService;
import com.ms.grademaster.comons.dto.*;
import com.ms.grademaster.comons.entity.CarreraEntity;
import com.ms.grademaster.comons.entity.EstadoEntity;
import com.ms.grademaster.comons.mapper.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriasService implements IMateriasService {

    private final MateriaRepository materiaRepository;

    private final MateriaMapper materiaMapper;

    private final CarreraMateriaMapper carreraMateriaMapper;

    private final MateriaCarrearRepository materiaCarrearRepository;

    private final EstadoRepository estadoRepository;

    private final MateriaHorarioRepository materiaHorarioRepository;

    private final MateriaHorarioMapper materiaHorarioMapper;

    private final SemestreMapper semestreMapper;

    private final EstadoMapper estadoMapper;


    @Override
    public List<MateriaDto> getAllMaterias() {
        return materiaMapper.listEntityToListDto(materiaRepository.findAll());
    }

    @Override
    public List<MateriaDto> getMateriasInCarrera(Long idCarrera) {
        return materiaMapper.listObjectToListDto(materiaCarrearRepository.findAllMateriasByIdCarrera(idCarrera));
    }

    @Override
    @Transactional
    public void createCarreraMateria(CarreraEntity carrera, List<MateriaDto> materias) {
        materiaCarrearRepository.saveAll(carreraMateriaMapper.listMateriasAndIdCarreraToListEntity(
                carrera,
                materiaMapper.listDtoToListEntity(materias)));
    }

    @Override
    @Transactional
    public void crearMateria(MateriaDto materia, List<HorarioDTO> horarios, SemestreDto semestre) {
        EstadoDto estadoDto = estadoMapper.entityToDto(estadoRepository.findByNombre("HABILITADO"));
        materia.setEstadoEntityFk(estadoDto);
        materiaRepository.save(materiaMapper.dtoToEntity(materia));
        materiaHorarioRepository.saveAll(materiaHorarioMapper.objetosListToMateriaHorario(
                materiaMapper.dtoToEntity(materia),
                horarios,
                estadoMapper.dtoToEntity(estadoDto),
                semestreMapper.dtoToEntity(semestre)
        ));
    }


}
