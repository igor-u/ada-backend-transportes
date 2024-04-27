package com.ada.rotas.demotomtom.repository;

import com.ada.rotas.demotomtom.model.rota.pathpoint.RoutePathPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutePathPointRepository extends JpaRepository<RoutePathPoint, Long> {
}
