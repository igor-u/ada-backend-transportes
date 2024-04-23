package com.ada.rotas.demotomtom.model.rota;

import java.util.List;

public record ExibicaoRotaDTO(
        Long routeId,
        String routeName,
        RouteStatus routeStatus,
        List<RoutePathPoint> routePathPoints,
        Boolean passable,
        Double routeLength,
        Double travelTime) {

        public ExibicaoRotaDTO(Rota rota) {
            this(rota.getRouteId(), rota.getRouteName(), rota.getRouteStatus(), rota.getRoutePathPoints(), rota.getPassable(), Double.valueOf(rota.getRouteLength()/1000), Double.valueOf(rota.getTravelTime()/60));
        }

}
