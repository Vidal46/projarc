package com.pucrs.airwayManager.application.DTO;



public class AirplaneDTO {

    public int prefix;
    public String type;
    public float cruiseSpeed;
    public double autonomy;
    public AirplaneDTO(int prefix, String type, float cruiseSpeed, double autonomy) {
        this.prefix = prefix;
        this.type = type;
        this.cruiseSpeed = cruiseSpeed;
        this.autonomy = autonomy;
    }
}
