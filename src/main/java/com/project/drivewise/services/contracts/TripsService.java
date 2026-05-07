package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.entities.Trips;

import java.util.List;
import java.util.Optional;

public interface TripsService {

    List<Trips> findAll();

    Optional<Trips> findById(Long id);

    Trips save(Trips trip);

    void delete(Trips trip);

    void deleteById(Long id);
}
