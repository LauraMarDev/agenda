package com.agenda.contato.dtos;

import java.sql.Date;

public record ContatoResponse(
    Long id,
    String nickname,
    String fullname,
    String occupation,
    Date birthday,
    String address,
    String email,
    String number,
    TipoResponse type,
    Boolean favorite
) {}
