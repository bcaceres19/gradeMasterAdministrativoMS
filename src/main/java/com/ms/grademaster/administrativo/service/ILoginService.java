package com.ms.grademaster.administrativo.service;

import com.ms.grademaster.comons.dto.RespuestaGeneralDto;

public interface ILoginService {

    RespuestaGeneralDto iniciarSesion(String codigo, String cedula);

}
