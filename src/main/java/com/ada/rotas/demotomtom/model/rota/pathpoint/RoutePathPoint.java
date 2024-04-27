package com.ada.rotas.demotomtom.model.rota.pathpoint;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "RoutePathPoint")
@Table(name = "route_path_points")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoutePathPoint {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long pathPointId;
        private Double latitude;
        private Double longitude;

}
