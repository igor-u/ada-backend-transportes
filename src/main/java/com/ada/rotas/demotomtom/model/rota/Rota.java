package com.ada.rotas.demotomtom.model.rota;

import com.ada.rotas.demotomtom.model.rota.pathpoint.RoutePathPoint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Rota")
@Table(name = "rotas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Rota {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long routeId;
        private String routeName;
        private RouteStatus routeStatus;
        @OneToMany
        private List<RoutePathPoint> routePathPoints;
        private Boolean passable;
        private Integer routeLength;
        private Integer travelTime;
        private Integer delayTime;
        private Integer typicalTravelTime;
        private Integer completeness;
        private Integer routeConfidence;
        private Integer typicalTravelTimeCoverage;

        public void atualizar(RotaAtualizacaoDTO atualizacao) {
                if(atualizacao.routeName() != null) {
                        this.routeName = atualizacao.routeName();
                }
        }
}
