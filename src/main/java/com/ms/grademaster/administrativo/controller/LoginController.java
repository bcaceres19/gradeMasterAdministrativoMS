package com.ms.grademaster.administrativo.controller;

import com.ms.grademaster.administrativo.service.ILoginService;
import com.ms.grademaster.comons.dto.RespuestaGeneralDto;
import com.ms.grademaster.comons.utils.enums.EstadoRespuestaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final ILoginService iLoginService;

    @GetMapping("")
    public ResponseEntity<RespuestaGeneralDto> loginUsuario(@RequestParam("codigo") String codigo,
                                                           @RequestParam("cedula") String cedula){
        RespuestaGeneralDto respuesta = iLoginService.iniciarSesion(codigo, cedula);
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        return ResponseEntity.ok(respuesta);
    }

}
