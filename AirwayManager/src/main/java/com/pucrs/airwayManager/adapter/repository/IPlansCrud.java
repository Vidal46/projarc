package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.application.DTO.FlightPlanDTO;
import com.pucrs.airwayManager.domain.entitie.ModelFlightPlan;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlansCrud extends JpaRepository<ModelFlightPlan, Integer> {

    List<ModelFlightPlan> findAllPlans();

    ModelFlightPlan findPlanById(int planID);

    FlightPlanDTO savePlan(FlightPlanDTO flightPlanDTO);

    void removePlan(ModelFlightPlan plan);

    ModelFlightPlan findPlanByAeroviaId(int aeroviaId);

    ModelFlightPlan findPlanByAeroviaIdAndRouteId(int aeroviaId, int routeId);

}
