package com.pucrs.airwayManager.application.DTO;

public class OccupationPercentageDTO {
    
    public int altitude;
    public float occupationPercentage;
    public OccupationPercentageDTO(int altitude, float porcentagemOcupacao){
        this.altitude = altitude;
        this.occupationPercentage = porcentagemOcupacao;
    }
}
