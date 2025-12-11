package com.agenda.contato.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.contato.Entities.tipo;

@Repository
public interface TipoRepository extends JpaRepository<tipo, Long> {
    
}
