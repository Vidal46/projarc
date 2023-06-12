package com.pucrs.airwayManager.domain.entitie;

import javax.persistence.*;

@Entity
@Table(name = "ref_geo")
public class ModelRefGeo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public float latitude;
    public float longitude;

    public ModelRefGeo(){
        
    }

}
