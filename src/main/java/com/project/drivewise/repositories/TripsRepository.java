package com.project.drivewise.repositories;

import com.project.drivewise.entities.Trips;
import com.project.drivewise.entities.enums.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripsRepository extends JpaRepository<Trips, Long> {

    List<Trips> findByUser_Id(long userId);
    List<Trips> findByUser_IdAndStatus(long userId, TripStatus status);

    Long id(long id);

}
