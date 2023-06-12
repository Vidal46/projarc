package com.pucrs.airwayManager.adapter.repository;

import com.pucrs.airwayManager.domain.entitie.ModelRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRouteCrud extends JpaRepository<ModelRoute, Integer> {


}
