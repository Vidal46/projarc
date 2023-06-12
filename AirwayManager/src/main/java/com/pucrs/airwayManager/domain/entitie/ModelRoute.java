package com.pucrs.airwayManager.domain.entitie;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "route")
public class ModelRoute {

    @ManyToMany
    @JoinTable(name = " airway_route ", joinColumns = @JoinColumn(name = " id_route "), inverseJoinColumns = @JoinColumn(name = " airway_id "))
    public List<ModelAirway> airways;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

    @ManyToOne
    @JoinColumn(name = "ref_geo_origin_id")
    public ModelRefGeo origin;

    @ManyToOne
    @JoinColumn(name = "ref_geo_destiny_id")
    public ModelRefGeo destination;

    public ModelRoute() {

    }
}
