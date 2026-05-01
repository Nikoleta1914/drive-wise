package com.project.drivewise.services;

import com.project.drivewise.entities.Trip;
import com.project.drivewise.repositories.TripRepository;
import com.project.drivewise.services.contracts.TripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public void delete(Trip trip) {
        tripRepository.delete(trip);
    }
}
