package com.pucrs.airwayManager.application.component;

import com.pucrs.airwayManager.application.DTO.FlightPlanDTO;
import com.pucrs.airwayManager.domain.service.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeFlightPlan {
    @Autowired
    public AuthorizeFlightPlan(PlanService planService){
        this.planService = planService;
    }
    private final PlanService planService;
    public FlightPlanDTO authoryzeFlightPlan(FlightPlanDTO planoVoo){
        return this.planService.authorizeFlightPlan(planoVoo);
    }
}
