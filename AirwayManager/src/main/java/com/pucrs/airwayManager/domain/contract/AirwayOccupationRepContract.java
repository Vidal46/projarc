package com.pucrs.airwayManager.domain.contract;

import com.pucrs.airwayManager.domain.entitie.ModelAirwayOccupation;

import java.time.LocalDate;
import java.util.List;

public interface AirwayOccupationRepContract {
    void removeOccupation(ModelAirwayOccupation airwayOccupation);
    ModelAirwayOccupation ocupate(ModelAirwayOccupation airwayOccupation);
    List<ModelAirwayOccupation> findOccupadeSlots(int airwayID, LocalDate date, List<Float> slotsTimes);
    List<ModelAirwayOccupation> findAllAirwaysOccupiedByDate(int airwayID, LocalDate date);
}
