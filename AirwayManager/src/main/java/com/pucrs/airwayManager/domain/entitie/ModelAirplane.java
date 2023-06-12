package com.pucrs.airwayManager.domain.entitie;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class ModelAirplane {

    @Id
    public int prefix;
    public String type;
    public double autonomy;
    public float cruiseSpeed;
    public ModelAirplane(){}
}
