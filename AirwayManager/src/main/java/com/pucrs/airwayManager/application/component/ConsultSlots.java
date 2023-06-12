package com.pucrs.airwayManager.application.component;

import com.pucrs.airwayManager.domain.service.AirwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsultSlots {
    @Autowired
    public ConsultSlots(AirwayService airwayService) {
        this.airwayService = airwayService;
    }

    private final AirwayService airwayService;

    public List<Integer> consultFreeHights(int airwayId, LocalDate date, Float time, float cruiseSpeed) {
        return this.airwayService.freeSlotConsult(time, cruiseSpeed, airwayId, date);
    }
}
