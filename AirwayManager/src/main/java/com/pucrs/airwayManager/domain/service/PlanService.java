package com.pucrs.airwayManager.domain.service;

import com.pucrs.airwayManager.application.DTO.FlightPlanDTO;
import com.pucrs.airwayManager.domain.contract.AirplaneRepContract;
import com.pucrs.airwayManager.domain.contract.AirwayOccupationRepContract;
import com.pucrs.airwayManager.domain.contract.PlansRepContract;
import com.pucrs.airwayManager.domain.contract.RouteRepContract;
import com.pucrs.airwayManager.domain.entitie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {
    private final PlansRepContract plansRep;
    private final RouteRepContract routeRep;
    private AirplaneRepContract airplaneRep;
    private final AirwayOccupationRepContract airwayOccupationRep;

    @Autowired
    public PlanService(AirwayOccupationRepContract occupationRep, PlansRepContract plansRep, RouteRepContract routeRep) {
        this.airwayOccupationRep = occupationRep;
        this.plansRep = plansRep;
        this.routeRep = routeRep;
    }

    public List<ModelAirway> checkFlightPlan(FlightPlanDTO proposalPlan) {
        ModelRoute routeChosen = this.routeRep.findById(proposalPlan.routeID);
        List<ModelAirway> excerptsWithProblems = new ArrayList<>();

        for (ModelAirway airway : routeChosen.airways) {
            List<Float> slotTime = new ArrayList<>();
            float timeFlight = airway.distance / proposalPlan.cruiserSpeed;
            timeFlight = timeFlight + proposalPlan.departureTime;
            slotTime.add((float) Math.floor(proposalPlan.departureTime));

            if (timeFlight > proposalPlan.departureTime) {
                do {
                    slotTime.add((float) Math.floor(proposalPlan.departureTime));
                    timeFlight--;
                } while (timeFlight > proposalPlan.departureTime);
            }

            List<ModelAirwayOccupation> filled = this.airwayOccupationRep.findOccupadeSlots(
                    airway.id,
                    proposalPlan.date,
                    slotTime);
            for (ModelAirwayOccupation occupation : filled) {
                if (occupation.slotAltitude == proposalPlan.altitude) {
                    excerptsWithProblems.add(airway);
                }
            }
        }

        return excerptsWithProblems;
    }

    public ModelFlightPlan cancelFlightPlan(int id) {
        ModelFlightPlan plan = this.plansRep.findPlanById(id);
        if (plan != null) {
            ModelRoute route = plan.route;
            List<ModelAirway> Airways = route.airways;
            for (ModelAirway Airway : Airways) {
                List<Float> slotTime = new ArrayList<>();
                float flightTime = Airway.distance / plan.airplane.cruiseSpeed;
                for (int i = 0; i < flightTime; i++) {
                    slotTime.add((float) Math.floor(plan.slotTime + i));
                }
                List<ModelAirwayOccupation> slotOccupated = this.airwayOccupationRep
                        .findOccupadeSlots(Airway.id, plan.data, slotTime).stream()
                        .filter(o -> o.slotAltitude == plan.altitude)
                        .collect(Collectors.toList());
                slotOccupated.forEach(this.airwayOccupationRep::removeOccupation);
            }
            this.plansRep.removePlan(plan);
        }

        return plan;
    }

    public FlightPlanDTO authorizeFlightPlan(FlightPlanDTO f) {
        if (this.checkFlightPlan(f).isEmpty()) {
            ModelRoute rota = this.routeRep.findById(f.routeID);
            ModelAirplane airplane = this.airplaneRep.findAirplaneById(f.plane.prefix);
            FlightPlanDTO flightPlan = new FlightPlanDTO(f.routeID, f.date, airplane.cruiseSpeed,
            f.altitude, 0, airplane);
            for (ModelAirway Airway : rota.airways) {
                List<Float> slotTime = new ArrayList<>();
                float tempoVoo = Airway.distance / flightPlan.plane.cruiseSpeed;
                for (int i = 0; i < tempoVoo; i++) slotTime.add((float) Math.floor(flightPlan.departureTime + i));
                for (float slot : slotTime) {
                    LocalDate date = flightPlan.date;
                    if (slot > 24) {
                        slot = slot - 24;
                        date = date.plusDays(1);
                    }
                    ModelAirwayOccupation ocupationAirway = new ModelAirwayOccupation(date, Airway, (int) flightPlan.altitude,
                            (int) slot);
                    this.airwayOccupationRep.ocupate(ocupationAirway);
                }
            }
            return this.plansRep.savePlan(flightPlan);
        }
        return null;
    }
}
