package com.pucrs.airwayManager.domain.contract;

import com.pucrs.airwayManager.application.DTO.FlightPlanDTO;
import com.pucrs.airwayManager.domain.entitie.ModelFlightPlan;

import java.util.List;

public interface PlansRepContract {
    List<ModelFlightPlan> findPlans();
    void removePlan(ModelFlightPlan plan);
    ModelFlightPlan findPlanById(int planID);
    FlightPlanDTO savePlan(FlightPlanDTO flightPlanDTO);
}

