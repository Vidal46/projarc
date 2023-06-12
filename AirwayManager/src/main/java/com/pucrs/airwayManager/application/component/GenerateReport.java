package com.pucrs.airwayManager.application.component;

import java.time.LocalDate;

import com.pucrs.airwayManager.application.DTO.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pucrs.airwayManager.domain.service.AirwayService;

@Component
public class GenerateReport {
    @Autowired
    public GenerateReport(AirwayService airwayService) {
        this.airwayService = airwayService;
    }
    private final AirwayService airwayService;
    public ReportDTO generateReport(int airwayId, LocalDate data){
        return this.airwayService.consultationPercentageOccupation(airwayId, data);
    }
}
