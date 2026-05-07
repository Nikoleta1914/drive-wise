package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.TelemetryPoints;

import java.util.List;

public interface TelemetryPointsService {

    List<TelemetryPoints> findAll();

    TelemetryPoints save(TelemetryPoints telemetryPoint);

    void delete(TelemetryPoints telemetryPoint);
}
