package com.ada.rotas.demotomtom.controller;

import com.ada.rotas.demotomtom.model.rota.ExibicaoRotaDTO;
import com.ada.rotas.demotomtom.model.rota.RotaAtualizacaoDTO;
import com.ada.rotas.demotomtom.model.rota.pathpoint.RoutePathPoint;
import com.ada.rotas.demotomtom.repository.RotaRepository;
import com.ada.rotas.demotomtom.repository.RoutePathPointRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rotas")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private RoutePathPointRepository routePathPointRepository;

    public RotaController(RotaRepository rotaRepository, RoutePathPointRepository routePathPointRepository) {
        this.rotaRepository = rotaRepository;
        this.routePathPointRepository = routePathPointRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var rota = rotaRepository.getReferenceById(id);
        return ResponseEntity.ok(rota);
    }

    @GetMapping
    public ResponseEntity<Page<ExibicaoRotaDTO>> listar(@PageableDefault(size = 10, sort = {"routeId"}) Pageable pageable) {
        var page = rotaRepository.findAll(pageable).map(ExibicaoRotaDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid RotaAtualizacaoDTO atualizacao) {
        var rota = rotaRepository.getReferenceById(atualizacao.routeId());
        rota.atualizar(atualizacao);
        return ResponseEntity.ok(new ExibicaoRotaDTO(rota));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var rota = rotaRepository.getReferenceById(id);
        for (RoutePathPoint rpp : rota.getRoutePathPoints()) {
            routePathPointRepository.delete(rpp);
        }
        rotaRepository.delete(rota);
        return ResponseEntity.noContent().build();
    }

}
