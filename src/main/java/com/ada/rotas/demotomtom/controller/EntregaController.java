package com.ada.rotas.demotomtom.controller;

import com.ada.rotas.demotomtom.model.Entrega;
import com.ada.rotas.demotomtom.repository.EntregaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository repository;

    public EntregaController(EntregaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var entrega = repository.getReferenceById(id);
        return ResponseEntity.ok(new Entrega());
    }

    @GetMapping
    public ResponseEntity<Page<Entrega>> listar(@PageableDefault(size = 10, sort = {"idEntrega"}) Pageable pageable) {
        var page = repository.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Entrega entrega, UriComponentsBuilder uriBuilder) {
        repository.save(entrega);
        var uri = uriBuilder.path("/entregas/{id}").buildAndExpand(entrega.getIdEntrega()).toUri();
        return ResponseEntity.created(uri).body(new Entrega());
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid Entrega atualizacao) {
        var entrega = repository.getReferenceById(atualizacao.getIdEntrega());
        entrega.atualizar(atualizacao);
        return ResponseEntity.ok(new Entrega());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var entrega = repository.getReferenceById(id);
        repository.delete(entrega);
        return ResponseEntity.noContent().build();
    }


}
