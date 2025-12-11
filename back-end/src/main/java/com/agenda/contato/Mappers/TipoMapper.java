package com.agenda.contato.Mappers;

import com.agenda.contato.Entities.tipo;
import com.agenda.contato.dtos.TipoRequest;
import com.agenda.contato.dtos.TipoResponse;

public class TipoMapper {
    public static tipo toEntity(TipoRequest request) {
        tipo type = new tipo();
        type.setName(request.name());
        return type;
    }

    public static TipoResponse toResponse(tipo type) {
        return new TipoResponse(
            type.getId(),
            type.getName()
        );
    }
}