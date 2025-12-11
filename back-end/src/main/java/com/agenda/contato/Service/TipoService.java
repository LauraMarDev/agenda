package com.agenda.contato.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.contato.Mappers.TipoMapper;
import com.agenda.contato.Repositories.TipoRepository;
import com.agenda.contato.Entities.tipo;
import com.agenda.contato.dtos.TipoRequest;
import com.agenda.contato.dtos.TipoResponse;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoService {
    @Autowired
    private TipoRepository repository;

    public List<TipoResponse> getAllTipo() {
        return repository.findAll()
                         .stream()
                         .map(TipoMapper::toResponse)
                         .toList();
    }

    public TipoResponse getTipoById(Long id) {
        tipo type = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado"));
        return TipoMapper.toResponse(type);
    }

    public TipoResponse createTipo(TipoRequest request) {
        tipo type = TipoMapper.toEntity(request);
        type = repository.save(type);
        return TipoMapper.toResponse(type);
    }

    public TipoResponse updateTipo(Long id, TipoRequest request) {
        tipo type = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado"));
        type.setName(request.name());
        type = repository.save(type);
        return TipoMapper.toResponse(type);
    }

    public void deleteTipo(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Tipo não encontrado");
        }
        repository.deleteById(id);
    }
}
