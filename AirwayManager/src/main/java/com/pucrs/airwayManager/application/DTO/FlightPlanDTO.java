package com.pucrs.airwayManager.application.DTO;
import java.time.LocalDate;

import com.pucrs.airwayManager.domain.entitie.ModelAirplane;

public class FlightPlanDTO {
    public int routeID;
    public LocalDate date;
    public float departureTime;
    public float cruiserSpeed;
    public int altitude;
    public ModelAirplane plane;

    public FlightPlanDTO(int routeID, LocalDate date, float departureTime, float cruiserSpeed, int altitude, ModelAirplane plane) {
        this.routeID = routeID;
        this.date = date;
        this.departureTime = departureTime;
        this.cruiserSpeed = cruiserSpeed;
        this.altitude = altitude;
        this.plane = plane;
    }
}