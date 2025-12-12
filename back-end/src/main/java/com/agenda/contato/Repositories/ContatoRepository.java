package com.agenda.contato.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.contato.entities.Contato;

public interface ContatoRepository extends JpaRepository <Contato, Long> {

    List<Contato> findByFavoriteTrue(Sort sort);

    List<Contato> findByNumber(String number);

    List<Contato> findByFullnameContainingIgnoreCase(String fullname);

    List<Contato> findByAddressIgnoreCase(String address);

    List<Contato> findByNicknameContainingIgnoreCase(String nickname);
    
    List<Contato> getContatoById(Long id);
} 
