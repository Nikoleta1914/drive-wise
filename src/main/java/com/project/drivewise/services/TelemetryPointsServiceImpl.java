package com.project.drivewise.services;

import com.project.drivewise.entities.TelemetryPoints;
import com.project.drivewise.repositories.TelemetryPointsRepository;
import com.project.drivewise.services.contracts.TelemetryPointsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelemetryPointsServiceImpl implements TelemetryPointsService {

    private TelemetryPointsRepository telemetryPointRepository;

    @Override
    public List<TelemetryPoints> findAll() {
        return telemetryPointRepository.findAll();
    }

    @Override
    public TelemetryPoints save(TelemetryPoints telemetryPoint) {
       return telemetryPointRepository.save(telemetryPoint);
    }

    @Override
    public void delete(TelemetryPoints telemetryPoint) {
        telemetryPointRepository.delete(telemetryPoint);

    }
}
