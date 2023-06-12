package com.pucrs.airwayManager.application.component;

import com.pucrs.airwayManager.application.DTO.FlightPlanDTO;
import com.pucrs.airwayManager.domain.entitie.ModelAirway;
import com.pucrs.airwayManager.domain.service.PlanService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifyFlightPlan {

    @Autowired
    public VerifyFlightPlan(PlanService planService){
        this.planService = planService;
    }
    private final PlanService planService;
    public List<ModelAirway> verifyFlightPlanList(FlightPlanDTO flightPlanDTO){
        return this.planService.checkFlightPlan(flightPlanDTO);
    }
}
