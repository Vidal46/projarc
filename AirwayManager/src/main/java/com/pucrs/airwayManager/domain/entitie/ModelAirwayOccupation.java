package com.pucrs.airwayManager.domain.entitie;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Table(name = "airway_occupation")
public class ModelAirwayOccupation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_airway")
    public ModelAirway airway;
    public int slotAltitude;
    public int slotTime;
    public Object airwayaux;

    public ModelAirwayOccupation(LocalDate data, ModelAirway airway, int slot_altitude, int slot_horario) {
        this.date = data;
        this.airway = airway;
        this.slotAltitude = slot_altitude;
        this.slotTime = slot_horario;
    }
}