package com.ms.grademaster.administrativo.dto;

import com.ms.grademaster.comons.utils.enums.RolUsuarioEnum;
import lombok.Data;

@Data
public class LoginDTO {

    private Object data;

    private RolUsuarioEnum rol;

}
