package com.pucrs.airwayManager.domain.service;

import com.pucrs.airwayManager.domain.contract.RouteRepContract;
import com.pucrs.airwayManager.domain.entitie.ModelRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    @Autowired
    public RouteService(RouteRepContract rotasRep) {
        this.routeRep = rotasRep;
    }
    private RouteRepContract routeRep;
    public List<ModelRoute> checkRoute(String origem, String destino) {
        return routeRep.findRoutes().stream()
                .filter(rota -> rota.destination.name.toLowerCase().equals(destino.toLowerCase())
                        && rota.origin.name.toLowerCase().equals(origem.toLowerCase()))
                .collect(Collectors.toList());
    }
}
