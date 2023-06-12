package com.pucrs.airwayManager.domain.contract;
import java.util.*;

import com.pucrs.airwayManager.domain.entitie.ModelAirplane;


public interface AirplaneRepContract {
    List<ModelAirplane> airplanes();
    ModelAirplane findAirplaneById(int airwayID);
}
