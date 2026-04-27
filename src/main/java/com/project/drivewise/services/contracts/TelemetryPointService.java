package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.TelemetryPoint;

import java.util.List;

public interface TelemetryPointService {

    List<TelemetryPoint> findAll();

    TelemetryPoint save(TelemetryPoint telemetryPoint);

    void delete(TelemetryPoint telemetryPoint);
}
