package com.ms.grademaster.administrativo.service.impl;

import com.ms.grademaster.administrativo.dto.GenerosDTO;
import com.ms.grademaster.administrativo.service.IGenerosService;
import com.ms.grademaster.comons.utils.enums.GenerosEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GenerosService implements IGenerosService {

    @Override
    public List<GenerosDTO> allGeneros() {
        return Arrays.stream(GenerosEnum.values()).map((g) -> {
            GenerosDTO generosDTO = new GenerosDTO();
            generosDTO.setNombre(g.name());
            generosDTO.setDescripcion(g.getDescripcion());
            return generosDTO;
        }).toList();
    }
}
