package com.project.drivewise.services;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.entities.Trips;
import com.project.drivewise.repositories.TripsRepository;
import com.project.drivewise.services.contracts.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripsServiceImpl implements TripsService {

    private final TripsRepository tripsRepository;

    @Autowired
    public TripsServiceImpl(TripsRepository tripsRepository) {
        this.tripsRepository = tripsRepository;
    }

    @Override
    public List<Trips> findAll() {
        return tripsRepository.findAll();
    }

    @Override
    public Optional<Trips> findById(Long id) {
        return tripsRepository.findById(id);
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
