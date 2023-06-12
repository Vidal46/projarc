package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.application.DTO.FlightPlanDTO;
import com.pucrs.airwayManager.domain.entitie.ModelFlightPlan;
import com.pucrs.airwayManager.domain.contract.PlansRepContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlansRepository implements PlansRepContract {
	private IPlansCrud plansCrud;

	@Autowired
	public PlansRepository(IPlansCrud plansCrud) {
		this.plansCrud = plansCrud;
	}

	@Override
	public List<ModelFlightPlan> findPlans() {
		return this.plansCrud.findAll();
	}

	@Override
	public ModelFlightPlan findPlanById(int planId) {
		return this.plansCrud.findById(planId).get();
	}

	@Override
	public FlightPlanDTO savePlan(FlightPlanDTO f) {
		return this.plansCrud.savePlan(f);
	}

	@Override
	public void removePlan(ModelFlightPlan plan) {
		this.plansCrud.delete(plan);
	}
}
