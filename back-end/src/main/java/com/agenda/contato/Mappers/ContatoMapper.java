package com.agenda.contato.Mappers;

import com.agenda.contato.Entities.contato;
import com.agenda.contato.dtos.ContatoRequest;
import com.agenda.contato.dtos.ContatoResponse;

public class ContatoMapper {

    public static contato toEntity(ContatoRequest request) {
        contato c = new contato();
        c.setNickname(request.nickname());
        c.setFullname(request.fullname());
        c.setOccupation(request.occupation());
        c.setBirthday(request.birthday());
        c.setAddress(request.address());
        c.setEmail(request.email());
        c.setNumber(request.number());
        c.setFavorite(request.favorite());

        return c;
    }

    public static ContatoResponse toDTO(contato Contato) {
        return new ContatoResponse(
            Contato.getId(),
            Contato.getNickname(),
            Contato.getFullname(),
            Contato.getOccupation(),
            Contato.getBirthday(),
            Contato.getAddress(),
            Contato.getEmail(),
            Contato.getNumber(),
            Contato.getType() != null ? TipoMapper.toResponse(contato.getType()) : null,
            Contato.getFavorite()
        );
    }
}