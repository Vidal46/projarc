package com.pucrs.airwayManager.domain.service;

import com.pucrs.airwayManager.application.DTO.OccupationPercentageDTO;
import com.pucrs.airwayManager.application.DTO.ReportDTO;
import com.pucrs.airwayManager.domain.contract.AirwayOccupationRepContract;
import com.pucrs.airwayManager.domain.contract.AirwayRepContract;
import com.pucrs.airwayManager.domain.entitie.ModelAirway;c
import com.pucrs.airwayManager.domain.entitie.ModelAirwayOccupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirwayService {
    @Autowired
    public AirwayService(AirwayRepContract airwayRep, AirwayOccupationRepContract airwayOccupationRep) {
        this.airwayRep = airwayRep;
        this.airwayOccupationRep = airwayOccupationRep;
    }
    private final AirwayRepContract airwayRep;
    private final AirwayOccupationRepContract airwayOccupationRep;


    public List<Integer> freeSlotConsult(float time, float cruiseSpeed, int airwayId, LocalDate date) {
        ModelAirway airway;
        airway = airwayRep.findAirway(airwayId).get();
        List<Integer> holeSlots = new ArrayList<>(Arrays.asList(25000, 26000, 27000, 28000, 29000, 30000, 31000, 32000, 33000, 34000));
        List<Float> slotTimes = new ArrayList<>();
        float flightTime = airway.distance / cruiseSpeed;
        flightTime = flightTime + time;
        slotTimes.add((float) Math.floor(time));

        if (flightTime > time) {
            do {
                slotTimes.add((float) Math.floor(time));
                flightTime--;
            } while (flightTime > time);
        }

        slotTimes.add((float) Math.ceil(time));

        List<ModelAirwayOccupation> occupied = this.airwayOccupationRep.findOccupadeSlots(airwayId, date, slotTimes);

        List<Integer> occupiedAltitudes = occupied.stream().map(ocupaAerovia -> ocupaAerovia.slotAltitude)
                .collect(Collectors.toList());

        return holeSlots.stream().filter(freeSlots -> !occupiedAltitudes.contains(freeSlots))
                .collect(Collectors.toList());
    }

    public ReportDTO consultationPercentageOccupation(int aeroviaId, LocalDate data) {
        List<ModelAirwayOccupation> occupationAirways = this.airwayOccupationRep.findAllAirwaysOccupiedByDate(aeroviaId, data);
        List<OccupationPercentageDTO> occupationlist = new ArrayList<>();
        List<Integer> holeSlots = new ArrayList<>(Arrays.asList(25000, 26000, 27000, 28000, 29000, 30000, 31000, 32000, 33000, 34000));
        holeSlots.forEach(altitudeSlot -> {
            List<ModelAirwayOccupation> occupiedBySlot = occupationAirways.stream()
                    .filter(ocupacaoAerovia -> ocupacaoAerovia.slotAltitude == altitudeSlot)
                    .collect(Collectors.toList());
            float percentege = Float.parseFloat(String.format("%.2f", ((occupiedBySlot.size() * 100) / 24.0)));
            occupationlist.add(new OccupationPercentageDTO(altitudeSlot, percentege));
            occupiedBySlot.clear();
        });

        return new ReportDTO(occupationlist);
    }
}
