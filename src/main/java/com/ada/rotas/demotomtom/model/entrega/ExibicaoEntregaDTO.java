package com.ada.rotas.demotomtom.model.entrega;

import com.ada.rotas.demotomtom.model.rota.ExibicaoRotaDTO;

import java.time.LocalDateTime;

public record ExibicaoEntregaDTO(
        Long idEntrega,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        Boolean ativa,
        ExibicaoRotaDTO rota) {

    public ExibicaoEntregaDTO(Entrega entrega) {
        this(entrega.getIdEntrega(), entrega.getDescricao(), entrega.getInicio(), entrega.getFim(), entrega.getAtiva(), new ExibicaoRotaDTO(entrega.getRota()));
    }
}
