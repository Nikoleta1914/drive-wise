package com.project.drivewise.services;

import com.project.drivewise.entities.PointsLedger;
import com.project.drivewise.repositories.PointsLedgerRepository;
import com.project.drivewise.services.contracts.PointsLedgerService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PointsLedgerServiceImpl implements PointsLedgerService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PointsLedgerServiceImpl.class);
    private PointsLedgerRepository pointsLedgerRepository;

    Logger logger = Logger.getLogger((PointsLedgerServiceImpl.class).getName());

    @Override
    public List<PointsLedger> findAll() {
        return pointsLedgerRepository.findAll();
    }

    @Override
    public Optional<PointsLedger> findById(Long pointsId) {
        return pointsLedgerRepository.findById(pointsId);
    }

    @Override
    public PointsLedger save(PointsLedger pointsLedger) {
        return pointsLedgerRepository.save(pointsLedger);
    }

    @Override
    public void delete(PointsLedger pointsLedger) {
        pointsLedgerRepository.delete(pointsLedger);
        log.info("PointsLedger " + pointsLedger + " deleted");

    }
}
