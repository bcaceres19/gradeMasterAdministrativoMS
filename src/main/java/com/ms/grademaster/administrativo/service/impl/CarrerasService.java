package com.ms.grademaster.administrativo.service.impl;

import com.ms.grademaster.administrativo.repository.CarreraRepository;
import com.ms.grademaster.administrativo.service.ICarrerasService;
import com.ms.grademaster.administrativo.service.IMateriasService;
import com.ms.grademaster.comons.dto.CarreraDto;
import com.ms.grademaster.comons.dto.MateriaDto;
import com.ms.grademaster.comons.entity.CarreraEntity;
import com.ms.grademaster.comons.mapper.CarreraMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrerasService implements ICarrerasService {

    private final CarreraRepository carrerasRepository;

    private final CarreraMapper carreraMapper;

    private final IMateriasService iMateriasService;

    @Override
    public List<CarreraDto> consultarCarreras() {
        return carreraMapper.listEntityToListDto(carrerasRepository.findAll());
    }

    @Override
    @Transactional
    public void crearCarrera(CarreraDto carreraDto, List<MateriaDto> materias) throws RuntimeException {
        try{
            CarreraEntity carreraEntity = carrerasRepository.save(carreraMapper.dtoToEntity(carreraDto));
            iMateriasService.createCarreraMateria(carreraEntity, materias);
        }catch (Exception err){
            throw new RuntimeException("Error al crear la carrera");
        }

    }

}
