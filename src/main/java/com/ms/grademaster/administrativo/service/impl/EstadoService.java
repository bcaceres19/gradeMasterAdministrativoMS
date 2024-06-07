package com.ms.grademaster.administrativo.service.impl;

import com.ms.grademaster.administrativo.repository.EstadoRepository;
import com.ms.grademaster.administrativo.service.IEstadoService;
import com.ms.grademaster.comons.dto.EstadoDto;
import com.ms.grademaster.comons.mapper.EstadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoService implements IEstadoService {

    private final EstadoRepository estadoRepository;

    private final EstadoMapper estadoMapper;

    @Override
    public List<EstadoDto> consultarEstados() {
        return estadoMapper.listEntityToListDto(estadoRepository.findAll());
    }
}
