package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.domain.entitie.ModelRoute;
import com.pucrs.airwayManager.domain.contract.RouteRepContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteRepository implements RouteRepContract {
    private IRouteCrud routeCrud;

    @Autowired
    public RouteRepository(IRouteCrud routeCrud){
        this.routeCrud = routeCrud;
    }

    @Override
    public ModelRoute findById(int rotaId) {
        return this.routeCrud.findById(rotaId).get();
    }

    @Override
    public List<ModelRoute> findRoutes(){
        return this.routeCrud.findAll();
    }

}
