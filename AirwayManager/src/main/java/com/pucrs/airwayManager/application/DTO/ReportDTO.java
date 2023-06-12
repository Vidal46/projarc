package com.pucrs.airwayManager.application.DTO;

import java.util.List;

public class ReportDTO {
    
    public List<OccupationPercentageDTO> occupationList;
    public ReportDTO(List<OccupationPercentageDTO> occupationList){
        this.occupationList = occupationList;
    }
}
