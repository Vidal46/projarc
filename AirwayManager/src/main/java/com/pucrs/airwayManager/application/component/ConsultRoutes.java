package com.pucrs.airwayManager.application.component;

import com.pucrs.airwayManager.application.DTO.RouteDTO;
import com.pucrs.airwayManager.domain.entitie.ModelRoute;
import com.pucrs.airwayManager.domain.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ConsultRoutes {
    @Autowired
    public ConsultRoutes(RouteService servicoRotas) {
        this.routeService = servicoRotas;
    }
    private final RouteService routeService;

    public List<RouteDTO> searchRouteByDestiny(String destino, String origem){
        List<ModelRoute> rotasSelecionadas = this.routeService.checkRoute(destino, origem);
        List<RouteDTO> rotasSelecionadasDto = new ArrayList<>();
        rotasSelecionadas.forEach( rota -> rotasSelecionadasDto.add(new RouteDTO(rota)));
        return rotasSelecionadasDto;
    }
}
