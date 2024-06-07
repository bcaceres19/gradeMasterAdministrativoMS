package com.ms.grademaster.administrativo.controller;

import com.ms.grademaster.administrativo.dto.CrearMateriaDTO;
import com.ms.grademaster.administrativo.service.IMateriasService;
import com.ms.grademaster.comons.dto.RespuestaGeneralDto;
import com.ms.grademaster.comons.service.IGenerarRecursos;
import com.ms.grademaster.comons.utils.constants.Constantes;
import com.ms.grademaster.comons.utils.enums.EstadoRespuestaEnum;
import com.ms.grademaster.comons.utils.enums.TipoUsuarioEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final IMateriasService iMateriasService;

    private final IGenerarRecursos iGenerarRecursos;

    @GetMapping("/all")
    public ResponseEntity<RespuestaGeneralDto> getAllMaterias(){
            RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
            respuesta.setEstado(EstadoRespuestaEnum.OK);
            respuesta.setData(iMateriasService.getAllMaterias());
            return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/crear")
    public ResponseEntity<RespuestaGeneralDto> crearCarrera(@RequestBody CrearMateriaDTO crearMateriaDTO){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setEstado(EstadoRespuestaEnum.OK);
        iMateriasService.crearMateria(crearMateriaDTO.getMateria(), crearMateriaDTO.getHorarios(), crearMateriaDTO.getSemestre());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/codigo")
    public ResponseEntity<RespuestaGeneralDto> generarCodigo(){
        RespuestaGeneralDto respuestaGeneral =  new RespuestaGeneralDto();
        respuestaGeneral.setData(iGenerarRecursos.generarCodigo(null, TipoUsuarioEnum.MATERIA, Constantes.INICIALES_ESTUDIANTE));
        respuestaGeneral.setEstado(EstadoRespuestaEnum.OK);
        return ResponseEntity.ok(respuestaGeneral);
    }

}
