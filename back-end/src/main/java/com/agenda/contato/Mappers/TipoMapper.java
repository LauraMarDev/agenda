package com.agenda.contato.mappers;

import com.agenda.contato.dtos.TipoRequest;
import com.agenda.contato.dtos.TipoResponse;
import com.agenda.contato.entities.Tipo;

public class TipoMapper {
    public static Tipo toEntity(TipoRequest request) {
        Tipo type = new Tipo();
        type.setName(request.name());
        return type;
    }

    public static TipoResponse toResponse(Tipo type) {
        return new TipoResponse(
            type.getId(),
            type.getName()
        );
    }
}