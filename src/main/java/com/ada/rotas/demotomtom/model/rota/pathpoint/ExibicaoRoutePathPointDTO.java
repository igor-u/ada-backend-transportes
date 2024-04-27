package com.ada.rotas.demotomtom.model.rota.pathpoint;

public record ExibicaoRoutePathPointDTO(
        Double latitude,
        Double longitude) {

    public ExibicaoRoutePathPointDTO(RoutePathPoint routePathPoint) {
       this(routePathPoint.getLongitude(), routePathPoint.getLongitude());
    }
}
