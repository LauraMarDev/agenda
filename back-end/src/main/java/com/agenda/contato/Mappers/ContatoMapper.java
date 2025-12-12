package com.agenda.contato.mappers;

import com.agenda.contato.dtos.ContatoRequest;
import com.agenda.contato.dtos.ContatoResponse;
import com.agenda.contato.entities.Contato;

public class ContatoMapper {

    public static Contato toEntity(ContatoRequest request) {
        Contato c = new Contato();
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

    public static ContatoResponse toDTO(Contato contato) {
        return new ContatoResponse(
            contato.getId(),
            contato.getNickname(),
            contato.getFullname(),
            contato.getOccupation(),
            contato.getBirthday(),
            contato.getAddress(),
            contato.getEmail(),
            contato.getNumber(),
            contato.getType() != null ? TipoMapper.toResponse(contato.getType()) : null,
            contato.getFavorite()
        );
    }
}