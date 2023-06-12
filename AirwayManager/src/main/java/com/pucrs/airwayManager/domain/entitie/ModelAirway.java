package com.pucrs.airwayManager.domain.entitie;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "airway")
public class ModelAirway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public float distance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_geo_origin_id")
    public ModelRefGeo origin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_geo_destiny_id")
    public ModelRefGeo destination;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelRefGeo getDestination() {
        return destination;
    }

    public void setDestination(ModelRefGeo destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public ModelRefGeo getOrigin() {
        return origin;
    }

    public void setOrigin(ModelRefGeo origin) {
        this.origin = origin;
    }

}
