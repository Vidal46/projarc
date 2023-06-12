package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.domain.entitie.ModelAirwayOccupation;
import com.pucrs.airwayManager.domain.contract.AirwayOccupationRepContract;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirwayOccupationRepository implements AirwayOccupationRepContract {
	private IAirwayOccupationCrud airwayOccupationCrud;

	@Autowired
	public AirwayOccupationRepository(IAirwayOccupationCrud airwayOccupationCrud) {
		this.airwayOccupationCrud = airwayOccupationCrud;
	}

	@Override
	public List<ModelAirwayOccupation> findOccupadeSlots(int airwayId, LocalDate date, List<Float> timeSlots) {
		return airwayOccupationCrud.findAll().stream()
		.filter(oa -> oa.airway.id == airwayId)
		.filter(oa -> oa.date.equals(date))
		.filter(oa -> timeSlots.contains((float) oa.slotTime))
		.collect(Collectors.toList());
	}

	@Override
	public ModelAirwayOccupation ocupate(ModelAirwayOccupation occupationAirway){
		return airwayOccupationCrud.save(occupationAirway);
	}

	@Override
	public void removeOccupation(ModelAirwayOccupation occupationAirway) {
		this.airwayOccupationCrud.delete(occupationAirway);
	}

	@Override
	public List<ModelAirwayOccupation> findAllAirwaysOccupiedByDate(int airwayId, LocalDate date){
		return airwayOccupationCrud.findAll().stream().filter(oa -> oa.airway.id == airwayId)
		.filter(oa -> oa.date.equals(date))
		.collect(Collectors.toList());
	}

}
