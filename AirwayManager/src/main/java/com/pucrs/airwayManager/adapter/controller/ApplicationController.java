package com.pucrs.airwayManager.adapter.controller;

import com.pucrs.airwayManager.application.DTO.FlightPlanDTO;
import com.pucrs.airwayManager.application.DTO.ReportDTO;
import com.pucrs.airwayManager.application.DTO.RouteDTO;
import com.dev.airwayManager.application.component.*;
import com.pucrs.airwayManager.domain.entitie.ModelAirway;
import com.pucrs.airwayManager.domain.entitie.ModelFlightPlan;

import com.pucrs.airwayManager.application.component.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/menuTraffic")
public class ApplicationController {

    @Autowired
    public ApplicationController(ConsultRoutes routeConsult, ConsultSlots slotsConsult,
                                 VerifyFlightPlan verifyFlightPlan, AuthorizeFlightPlan authorizeFlightPlan,
                                 CancelFlightPlan cancelFlightPlan, GenerateReport generateReport) {
        this.slotsConsult = slotsConsult;
        this.verifyFlightPlan = verifyFlightPlan;
        this.authorizeFlightPlan = authorizeFlightPlan;
        this.cancelFlightPlan = cancelFlightPlan;
        this.generateReport = generateReport;
        this.routeConsult = routeConsult;
    }

    private final ConsultRoutes routeConsult;
    private final ConsultSlots slotsConsult;
    private final GenerateReport generateReport;
    private final VerifyFlightPlan verifyFlightPlan;
    private final AuthorizeFlightPlan authorizeFlightPlan;
    private final CancelFlightPlan cancelFlightPlan;

    @PostMapping("/release-plan")
    @CrossOrigin(origins = "*")
    public ResponseEntity<FlightPlanDTO> releasePlan(@RequestBody FlightPlanDTO flightPlan) {
        FlightPlanDTO plano = this.authorizeFlightPlan.authoryzeFlightPlan(flightPlan);
        if (plano != null) {
            return ResponseEntity.status(HttpStatus.OK).body(plano);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/cancel-plan/{planID}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ModelFlightPlan> cancelPlan(@PathVariable int planID) {
        ModelFlightPlan plan = this.cancelFlightPlan.cancelFlightPlan(planID);
        if (plan == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(plan);
        return ResponseEntity.status(HttpStatus.OK).body(plan);
    }

    @GetMapping("/report/{airwayID}")
    @CrossOrigin(origins = "*")
    public ReportDTO generateReport(@PathVariable int airwayID, @RequestParam("date") String date) {
        LocalDate dateObj = LocalDate.parse(date);
        return this.generateReport.generateReport(airwayID, dateObj);
    }

    @GetMapping("/routes")
    @CrossOrigin(origins = "*")
    public List<RouteDTO> queryRoutesDestinations(@RequestParam("destination") String destination,
                                                  @RequestParam("origin") String origin) {
        return this.routeConsult.searchRouteByDestiny(destination, origin);
    }

    @GetMapping("/altitudes-free/{airwayID}")
    @CrossOrigin(origins = "*")
    public List<Integer> consultAltitudesFree(@PathVariable int airwayID, @RequestParam("date") String date,
                                              @RequestParam("time") float time, @RequestParam("velocidade") float cruiseSpeed) {
        LocalDate dateObj = LocalDate.parse(date);
        return this.slotsConsult.consultFreeHights(airwayID, dateObj, time, cruiseSpeed);
    }

    @PostMapping("/verify-flight-plan")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ModelAirway>> verifyFlightPlan(@RequestBody FlightPlanDTO flightPlan) {
        List<ModelAirway> list = this.verifyFlightPlan.verifyFlightPlanList(flightPlan);

        if (!list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
