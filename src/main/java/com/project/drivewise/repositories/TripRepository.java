package com.project.drivewise.repositories;

import com.project.drivewise.entities.Trip;
import com.project.drivewise.entities.enums.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {

    List<Trip> findByUser_Id(UUID userId);
    List<Trip> findByUser_IdAndStatus(UUID userId, TripStatus status);
}
