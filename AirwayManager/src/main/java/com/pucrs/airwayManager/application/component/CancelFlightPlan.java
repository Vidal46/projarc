package com.pucrs.airwayManager.application.component;

import com.pucrs.airwayManager.domain.entitie.ModelFlightPlan;
import com.pucrs.airwayManager.domain.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CancelFlightPlan {
    @Autowired
    public void cancelFlightPlan(PlanService planService){
        this.planService = planService;
    }
    private PlanService planService;
    public ModelFlightPlan cancelFlightPlan(int id){
        return this.planService.cancelFlightPlan(id);
    }
}
