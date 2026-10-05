package com.uc.ms_security.dto.user;

import lombok.Value;

@Value //Acá validaremos los campos para la salida o response del usuario, un ejemplo es no devolver la contraseña
public class UserResponseDTO {
    Long id;
    String name;
    String email;
}

//Se pueden validar datos cuando entran pero también cuando salen