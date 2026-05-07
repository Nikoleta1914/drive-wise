package com.project.drivewise.controllers;

import com.project.drivewise.entities.TelemetryPoints;
import com.project.drivewise.services.contracts.TelemetryPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telemetry-points")
public class TelemetryPointsController {

    private TelemetryPointsService telemetryPointsService;

    @Autowired
    public TelemetryPointsController(TelemetryPointsService telemetryPointsService) {
        this.telemetryPointsService = telemetryPointsService;
    }

    @GetMapping
    public List<TelemetryPoints> findAll(){
        return telemetryPointsService.findAll();
    }

    @PostMapping
    public TelemetryPoints save(@RequestBody TelemetryPoints telemetryPoints){
        return telemetryPointsService.save(telemetryPoints);
    }

    @DeleteMapping
    public String delete(@PathVariable TelemetryPoints telemetryPoints){
        telemetryPointsService.delete(telemetryPoints);
        return "Telemetry Points has been deleted.";
    }
}
