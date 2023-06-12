package com.pucrs.airwayManager.application.DTO;

import java.util.List;

import com.pucrs.airwayManager.domain.entitie.ModelAirway;
import com.pucrs.airwayManager.domain.entitie.ModelRoute;

public class RouteDTO {
    private String name;
    private int id;
    private List<ModelAirway> airways;

    public RouteDTO(String nome, int id, List<ModelAirway> airways) {
        this.name = nome;
        this.id = id;
        this.airways = airways;
    }

    public RouteDTO(ModelRoute rota) {
        this.name = rota.name;
        this.id = rota.id;
        this.airways = rota.airways;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ModelAirway> getairways() {
        return airways;
    }

    public void setAirways(List<ModelAirway> airways) {
        this.airways = airways;
    }

}
