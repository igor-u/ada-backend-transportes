package com.ada.rotas.demotomtom.controller;

import com.ada.rotas.demotomtom.model.rota.ExibicaoRotaDTO;
import com.ada.rotas.demotomtom.model.rota.Rota;
import com.ada.rotas.demotomtom.model.rota.pathpoint.RoutePathPoint;
import com.ada.rotas.demotomtom.repository.RotaRepository;
import com.ada.rotas.demotomtom.repository.RoutePathPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("routeapi")
public class ConsomeTomtom {

    @Autowired
    RotaRepository rotaRepository;

    @Autowired
    RoutePathPointRepository routePathPointRepository;

    @GetMapping("{rota}")
    public Rota consumir(@PathVariable("rota") String rotaId) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Rota> responseEntity =
                restTemplate
                        .getForEntity(
                                String.format("https://api.tomtom.com/routemonitoring/3/routes/%s/details?key=vh2AMu3LVDlluU4MAOBGG98k90hE6XyL", rotaId), Rota.class);
        Rota rota = responseEntity.getBody();
        for (RoutePathPoint rpp : rota.getRoutePathPoints()) {
            routePathPointRepository.save(rpp);
        }
        return rotaRepository.save(rota);
    }

}
