package com.project.drivewise.services;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.entities.Trips;
import com.project.drivewise.repositories.TripsRepository;
import com.project.drivewise.services.contracts.TripsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripsServiceImpl implements TripsService {

    private TripsRepository tripsRepository;

    @Override
    public List<Trips> findAll() {
        return tripsRepository.findAll();
    }

    @Override
    public List<Trips> findByTripId(long tripId) {
        return tripsRepository.findByTripId(tripId);
    }

    @Override
    public Trips save(Trips trip) {
        return tripsRepository.save(trip);
    }

    @Override
    public void delete(Trips trip) {
        tripsRepository.delete(trip);
    }

    @Override
    public void deleteById(Long id) {
        tripsRepository.deleteById(id);
    }
}
