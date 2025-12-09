package com.agenda.contato.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.agenda.contato.Entities.contato;
import com.agenda.contato.Mappers.ContatoMapper;
import com.agenda.contato.Repositories.ContatoRepository;
import com.agenda.contato.dtos.ContatoRequest;
import com.agenda.contato.dtos.ContatoResponse;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepository repository;

    public List<contato> getAll(){
        return repository.findAll();
        
    }

    /* Ordenação pelo nome */
    public List<ContatoResponse> getAllOrdenado(Sort sort) {
    return repository.findAll(sort)
        .stream()
        .map(ContatoMapper::toDTO)
        .toList();
    }

    /* Ordenação pelos favoritos */
    public List<ContatoResponse> getAllFavoritos(Sort sort) {
    return repository.findByFavoriteTrue(sort)
        .stream()
        .map(ContatoMapper::toDTO)
        .toList();
    }

    /* barrinha de busca para nome, apelido, ... */
    public List<ContatoResponse> findByAnything(String termo) {
    return Stream.<Function<String, List<contato>>>of(
        repository::findByNumber,
        repository::findByAddressIgnoreCase,
        repository::findByFullnameContainingIgnoreCase,
        repository::findByNicknameContainingIgnoreCase
    )
    .flatMap(f -> f.apply(termo).stream())
    .distinct()
    .collect(Collectors.toList())
    .stream()
    .map(ContatoMapper::toDTO)
    .toList();
    }
    
    public ContatoResponse save(ContatoRequest request){
        List<ContatoResponse> existingContato = repository.findByNumber(request.number())
        .stream()
        .map(ContatoMapper::toDTO)
        .toList();
        if (!existingContato.isEmpty()) {
            throw new IllegalArgumentException("Já existe um contato com este número.");
        }

        contato Contato = ContatoMapper.toEntity(request);
        contato savedContato = repository.save(Contato);

        return ContatoMapper.toDTO(savedContato);
    }

    public void update (ContatoRequest request, Long id){
        contato aux = repository.getReferenceById(id);
        aux.setNickname(request.nickname());
        aux.setFullname(request.fullname());
        aux.setOccupation(request.occupation());
        aux.setBirthday(request.birthday());
        aux.setAddress(request.address());
        aux.setEmail(request.email());
        aux.setNumber(request.number());
        aux.setType(request.type());
        aux.setFavorite(request.favorite());
        repository.save(aux);
    }

    public void delete(long id){
        if(repository.existsById(id))
        {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Not found");
        }
    }

    public ContatoResponse getContatoById(Long id) {
        return repository.findById(id)
        .map(ContatoMapper::toDTO)
        .orElseThrow(() -> new EntityNotFoundException("Contato com ID " + id + " não encontrado."));
    }
}
