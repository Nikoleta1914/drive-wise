package com.project.drivewise.services;

import com.project.drivewise.entities.TelemetryPoint;
import com.project.drivewise.repositories.TelemetryPointRepository;
import com.project.drivewise.services.contracts.TelemetryPointService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelemetryPointServiceImpl implements TelemetryPointService {

    private TelemetryPointRepository telemetryPointRepository;

    @Override
    public List<TelemetryPoint> findAll() {
        return telemetryPointRepository.findAll();
    }

    @Override
    public TelemetryPoint save(TelemetryPoint telemetryPoint) {
       return telemetryPointRepository.save(telemetryPoint);
    }

    @Override
    public void delete(TelemetryPoint telemetryPoint) {
        telemetryPointRepository.delete(telemetryPoint);

    }
}
