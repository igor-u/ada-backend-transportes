package com.ada.rotas.demotomtom.model.rota;

import com.ada.rotas.demotomtom.model.rota.pathpoint.ExibicaoRoutePathPointDTO;

import java.util.List;

public record ExibicaoRotaDTO(
        Long routeId,
        String routeName,
        RouteStatus routeStatus,
        List<ExibicaoRoutePathPointDTO> routePathPoints,
        Boolean passable,
        Double routeLength,
        Double travelTime) {

        public ExibicaoRotaDTO(Rota rota) {
            this(rota.getRouteId(), rota.getRouteName(), rota.getRouteStatus(), rota.getRoutePathPoints().stream().map(ExibicaoRoutePathPointDTO::new).toList(), rota.getPassable(), rota.getRouteLength()/1000.0, rota.getTravelTime()/60.0);
        }

}
