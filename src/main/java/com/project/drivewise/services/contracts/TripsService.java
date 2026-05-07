package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.entities.Trips;

import java.util.List;

public interface TripsService {

    List<Trips> findAll();

    List<Trips> findByTripId(long tripId);

    Trips save(Trips trip);

    void delete(Trips trip);

    void deleteById(Long id);
}
