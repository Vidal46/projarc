package com.pucrs.airwayManager.domain.contract;

import com.pucrs.airwayManager.domain.entitie.ModelRoute;

import java.util.List;

public interface RouteRepContract {
    List<ModelRoute> findRoutes();
    ModelRoute findById(int routeID);
}
