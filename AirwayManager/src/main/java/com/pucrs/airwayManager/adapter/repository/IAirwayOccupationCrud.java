package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.domain.entitie.ModelAirwayOccupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirwayOccupationCrud extends JpaRepository<ModelAirwayOccupation, Integer> {

}
