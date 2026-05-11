package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.PointsLedger;

import java.util.List;
import java.util.Optional;

public interface PointsLedgerService {

    List<PointsLedger> findAll();

    Optional<PointsLedger> findById(Long id);

    PointsLedger save(PointsLedger pointsLedger);

    void delete(PointsLedger pointsLedger);
}
