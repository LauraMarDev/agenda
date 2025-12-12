package com.agenda.contato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.contato.entities.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
    
}
