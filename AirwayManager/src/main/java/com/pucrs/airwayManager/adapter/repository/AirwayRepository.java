package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.domain.entitie.ModelAirway;
import com.pucrs.airwayManager.domain.contract.AirwayRepContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AirwayRepository implements AirwayRepContract {
	private IAirwayCrud airwayCrud;

	@Autowired
	public AirwayRepository(IAirwayCrud airwayCrud) {
		this.airwayCrud = airwayCrud;
	}

	@Override
	public Optional<ModelAirway> findAirway(int airwayId) {
		return this.airwayCrud.findById(airwayId);
	}

}
