package com.pucrs.airwayManager.domain.contract;

import com.pucrs.airwayManager.domain.entitie.ModelAirway;

import java.util.Optional;

public interface AirwayRepContract {
    Optional<ModelAirway> findAirway(int airwayId);
}
