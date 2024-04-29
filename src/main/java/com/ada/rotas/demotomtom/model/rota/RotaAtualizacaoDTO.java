package com.ada.rotas.demotomtom.model.rota;

import jakarta.validation.constraints.NotNull;

public record RotaAtualizacaoDTO(
        @NotNull
        Long routeId,
        String routeName
) {
}
