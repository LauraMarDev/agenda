package com.agenda.contato.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.contato.Service.*;
import com.agenda.contato.dtos.ContatoRequest;
import com.agenda.contato.dtos.ContatoResponse;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contato")
@CrossOrigin
public class ContatoController {
    
    @Autowired
    private ContatoService service;
    
    @GetMapping
    public ResponseEntity<List<ContatoResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/ordenado-fullname")
    public ResponseEntity<List<ContatoResponse>> getFullname( @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), "fullname");
        return ResponseEntity.ok(service.getAllOrdenado(sort));
    }

    @GetMapping("/ordenado-nickname")
    public ResponseEntity<List<ContatoResponse>> getNickname( @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), "nickname");
        return ResponseEntity.ok(service.getAllOrdenado(sort));
    }

    
    @GetMapping("/favoritos")
    public ResponseEntity<List<ContatoResponse>> getAllfavorite( @RequestParam (defaultValue = "favorite") String sortBy, @RequestParam(defaultValue = "asc") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        return ResponseEntity.ok(service.getAllFavoritos(sort));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ContatoResponse>> buscarPorTermo(@RequestParam String termo) {
    return ResponseEntity.ok(service.findByAnything(termo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponse> getContatoById(@PathVariable Long id) {
            return ResponseEntity.ok(service.getContatoById(id));         
    }

    @PostMapping
    public ResponseEntity<ContatoResponse>save(@Valid @RequestBody ContatoRequest request){

        ContatoResponse response = service.save(request);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(response.id())
            .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>update(@PathVariable long id, @Valid @RequestBody ContatoRequest request){
        service.update(request, id);
        return ResponseEntity.noContent().build();
    }
}
