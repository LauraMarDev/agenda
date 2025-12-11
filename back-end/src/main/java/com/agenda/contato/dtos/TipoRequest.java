package com.agenda.contato.dtos;

import jakarta.validation.constraints.NotBlank;

public record TipoRequest(
    @NotBlank(message = "Preenchimento obrigatório")
    String name
) {}
