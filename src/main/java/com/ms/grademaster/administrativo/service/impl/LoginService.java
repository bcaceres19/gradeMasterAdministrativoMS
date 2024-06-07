package com.ms.grademaster.administrativo.service.impl;

import com.ms.grademaster.administrativo.dto.LoginDTO;
import com.ms.grademaster.administrativo.repository.AdministrativoRepository;
import com.ms.grademaster.administrativo.repository.DocenteRepository;
import com.ms.grademaster.administrativo.repository.EstudianteRepository;
import com.ms.grademaster.administrativo.service.ILoginService;
import com.ms.grademaster.comons.dto.EstudianteDto;
import com.ms.grademaster.comons.dto.RespuestaGeneralDto;
import com.ms.grademaster.comons.mapper.AdministrativoMapper;
import com.ms.grademaster.comons.mapper.DocenteMapper;
import com.ms.grademaster.comons.mapper.EstudianteMapper;
import com.ms.grademaster.comons.utils.enums.RolUsuarioEnum;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class LoginService implements ILoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);
    private final EstudianteRepository estudianteRepository;

    private final DocenteRepository docenteRepository;

    private final AdministrativoRepository administrativoRepository;

    private final   EstudianteMapper estudianteMapper;

    private final DocenteMapper docenteMapper;

    private final AdministrativoMapper administrativoMapper;

    @Override
    public RespuestaGeneralDto iniciarSesion(String codigo, String cedula) {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        LoginDTO login = new LoginDTO();
        if(estudianteRepository.existsByCodigoEstudianteAndCedulaEstudiante(codigo, cedula)){
            login.setData(estudianteMapper.entityToDto(estudianteRepository.findById(codigo).orElse(null)));
            login.setRol(RolUsuarioEnum.ESTUDIANTE);
            respuesta.setData(login);
        }else if(docenteRepository.existsByCodigoDocenteAndCedulaDocente(codigo, cedula)){
            login.setData(docenteMapper.entityToDto(docenteRepository.findById(codigo).orElse(null)));
            login.setRol(RolUsuarioEnum.DOCENTE);
            respuesta.setData(login);
        }else if(administrativoRepository.existsByCodigoAdministrativoAndCedulaAdministrativo(codigo, cedula)){
            login.setData(administrativoMapper.entityToDto(administrativoRepository.findByCodigoAdministrativo(codigo)));
            login.setRol(RolUsuarioEnum.ADMINISTRATIVO);
            respuesta.setData(login);
        }
        return respuesta;
    }
}
