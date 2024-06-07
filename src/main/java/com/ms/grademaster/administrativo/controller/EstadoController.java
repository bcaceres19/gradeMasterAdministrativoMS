package com.ms.grademaster.administrativo.controller;

import com.ms.grademaster.administrativo.service.IEstadoService;
import com.ms.grademaster.comons.dto.RespuestaGeneralDto;
import com.ms.grademaster.comons.utils.enums.EstadoRespuestaEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
@RequiredArgsConstructor
public class EstadoController {

    private final IEstadoService estadoService;

    @GetMapping("/all")
    public ResponseEntity<RespuestaGeneralDto> allEstados(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        respuesta.setData(estadoService.consultarEstados());
        return ResponseEntity.ok(respuesta);
    }

}
