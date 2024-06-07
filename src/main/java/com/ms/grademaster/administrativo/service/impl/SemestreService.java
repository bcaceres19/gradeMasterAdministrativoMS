package com.ms.grademaster.administrativo.service.impl;

import com.ms.grademaster.administrativo.repository.SemestreRepository;
import com.ms.grademaster.administrativo.service.ISemestreService;
import com.ms.grademaster.comons.dto.SemestreDto;
import com.ms.grademaster.comons.mapper.SemestreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SemestreService implements ISemestreService {

    private final SemestreRepository semestreRepository;

    private final SemestreMapper semestreMapper;


    @Override
    public Boolean semestreVencido() {
        SemestreDto semestreDto = semestreMapper.objectToDto(semestreRepository.ultimoSemestre());
        return semestreDto.getFechaFin().isBefore(LocalDate.now());
    }

    @Override
    public SemestreDto getUltimoSemestre() {
        return  semestreMapper.objectToDto(semestreRepository.ultimoSemestre());
    }
}
