package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.Trip;

import java.util.List;

public interface TripService {

    List<Trip> findAll();

    Trip save(Trip trip);

    void delete(Trip trip);
}
