package com.pucrs.airwayManager.domain.entitie;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Table(name = "flight_plan")
public class ModelFlightPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public float slotTime;
    public LocalDate data;
    public float altitude;

    @ManyToOne
    @JoinColumn(name = "id_rota")
    public ModelRoute route;

    @ManyToOne
    @JoinColumn(name = "id Aeronave")
    public ModelAirplane airplane;

    public ModelFlightPlan(LocalDate date, ModelAirplane airplane, int altitude, ModelRoute route, float slotTime) {
        this.altitude = altitude;
        this.slotTime = slotTime;
        this.data = date;
        this.airplane = airplane;
        this.route = route;
    }
}
