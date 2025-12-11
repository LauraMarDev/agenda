package com.agenda.contato.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.contato.Service.TipoService;
import com.agenda.contato.dtos.TipoRequest;
import com.agenda.contato.dtos.TipoResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipo")
@CrossOrigin
public class TipoController {

    @Autowired
    private TipoService service;

    @GetMapping
    public ResponseEntity<List<TipoResponse>> getAllTipo(){
        List<TipoResponse> tipo = service.getAllTipo();
        return ResponseEntity.ok(tipo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoResponse> getTipoById(@PathVariable Long id) {
        TipoResponse type = service.getTipoById(id);
        return ResponseEntity.ok(type);
    }

    @PostMapping
    public ResponseEntity<TipoResponse> createTipo(@Valid @RequestBody TipoRequest request) {
        TipoResponse type = service.createTipo(request);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(type.id())
            .toUri();
        return ResponseEntity.created(location).body(type);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoResponse> updateTipo(@PathVariable Long id, @Valid @RequestBody TipoRequest request) {
        TipoResponse type = service.updateTipo(id, request);
        return ResponseEntity.ok(type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        service.deleteTipo(id);
        return ResponseEntity.noContent().build();
    }
}
