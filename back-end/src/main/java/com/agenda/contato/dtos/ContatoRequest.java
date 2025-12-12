package com.agenda.contato.dtos;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoRequest(
    @NotBlank (message = "Apelido é requerido!")
    String nickname,

    @NotBlank (message = "Nome completo é requerido!")
    String fullname,

    String occupation,
    Date birthday,
    String address,

    @NotBlank (message = "E-mail é requerido!")
    @Email (message = "E-mail inválido!")
    String email,

    @NotNull (message = "Tipo é requerido!")
    Long tipoId,

    @NotBlank (message = "Número é requerido!")
    String number,
    
    Boolean favorite
) {
}
