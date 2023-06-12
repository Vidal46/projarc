package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.domain.entitie.ModelAirway;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirwayCrud extends JpaRepository<ModelAirway, Integer> {

    Optional<ModelAirway> findAirway(int aeroviaId);
    List<ModelAirway> findAllAirways();

}
