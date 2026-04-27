package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.PointsLedger;

import java.util.List;

public interface PointsLedgerService {

    List<PointsLedger> findAll();

    PointsLedger save(PointsLedger pointsLedger);

    void delete(PointsLedger pointsLedger);
}
