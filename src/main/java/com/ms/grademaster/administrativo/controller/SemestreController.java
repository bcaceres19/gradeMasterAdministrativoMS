package com.ms.grademaster.administrativo.controller;

import com.ms.grademaster.administrativo.service.ISemestreService;
import com.ms.grademaster.comons.dto.RespuestaGeneralDto;
import com.ms.grademaster.comons.utils.enums.EstadoRespuestaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semestre")
@RequiredArgsConstructor
public class SemestreController {

    private final ISemestreService iSemestreService;

    @GetMapping("/ultimo")
    public ResponseEntity<RespuestaGeneralDto> ultimoSemestre(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        respuesta.setData(iSemestreService.getUltimoSemestre());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/semestre-vencido")
    public ResponseEntity<RespuestaGeneralDto> semestreVencido(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        respuesta.setData(iSemestreService.semestreVencido());
        return ResponseEntity.ok(respuesta);
    }
}
