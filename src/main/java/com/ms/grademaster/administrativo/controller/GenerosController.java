package com.ms.grademaster.administrativo.controller;

import com.ms.grademaster.administrativo.service.IGenerosService;
import com.ms.grademaster.comons.dto.RespuestaGeneralDto;
import com.ms.grademaster.comons.utils.enums.EstadoRespuestaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
public class GenerosController {

    private final IGenerosService iGenerosService;

    @GetMapping("/all")
    public ResponseEntity<RespuestaGeneralDto> allGeneros() {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        respuesta.setData(iGenerosService.allGeneros());
        return ResponseEntity.ok(respuesta);
    }
}
