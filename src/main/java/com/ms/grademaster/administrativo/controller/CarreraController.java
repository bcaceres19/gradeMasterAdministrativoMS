package com.ms.grademaster.administrativo.controller;

import com.ms.grademaster.administrativo.dto.CrearCarreraDTO;
import com.ms.grademaster.administrativo.service.ICarrerasService;
import com.ms.grademaster.comons.dto.CarreraDto;
import com.ms.grademaster.comons.dto.EstudianteDto;
import com.ms.grademaster.comons.dto.RespuestaGeneralDto;
import com.ms.grademaster.comons.service.IGenerarRecursos;
import com.ms.grademaster.comons.utils.constants.Constantes;
import com.ms.grademaster.comons.utils.enums.EstadoRespuestaEnum;
import com.ms.grademaster.comons.utils.enums.TipoUsuarioEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carreras")
@RequiredArgsConstructor
public class CarreraController {

    private final ICarrerasService iCarrerasService;
    private final IGenerarRecursos iGenerarRecursos;

    @GetMapping("/all-carreras")
    public ResponseEntity<RespuestaGeneralDto> allCarreras(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setData(iCarrerasService.consultarCarreras());
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/crear")
    public ResponseEntity<RespuestaGeneralDto> crearCarrera(@RequestBody CrearCarreraDTO  crearCarreraDTO){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        iCarrerasService.crearCarrera(crearCarreraDTO.getCarrera(), crearCarreraDTO.getMaterias());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/codigo")
    public ResponseEntity<RespuestaGeneralDto> generarCodigo(){
        RespuestaGeneralDto respuestaGeneral =  new RespuestaGeneralDto();
        respuestaGeneral.setData(iGenerarRecursos.generarCodigo(null, TipoUsuarioEnum.CARRERA, Constantes.INICIALES_CARRERA));
        respuestaGeneral.setEstado(EstadoRespuestaEnum.OK);
        return ResponseEntity.ok(respuestaGeneral);
    }

}
