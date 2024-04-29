package com.ada.rotas.demotomtom.model.entrega;

import com.ada.rotas.demotomtom.model.rota.ExibicaoRotaDTO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public record ExibicaoEntregaDTO(
        Long idEntrega,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        Double travelTime,
        Boolean ativa,
        ExibicaoRotaDTO rota) {

    public ExibicaoEntregaDTO(Entrega entrega) {
        this(entrega.getIdEntrega(),
                entrega.getDescricao(),
                entrega.getInicio(),
                entrega.getFim(),
                (ChronoUnit.SECONDS.between(entrega.getInicio(), Optional.ofNullable(entrega.getFim()).orElse(entrega.getInicio())))/60.0,
                entrega.getAtiva(),
                new ExibicaoRotaDTO(entrega.getRota()));
    }
}
