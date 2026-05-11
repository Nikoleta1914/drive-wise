package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.DrivingEvent;

import java.util.List;
import java.util.Optional;

public interface DrivingEventService {

    Optional<DrivingEvent> findById(long id);

    List<DrivingEvent> findByUserId(long userId);

    List<DrivingEvent> findAll();

    DrivingEvent save(DrivingEvent drivingEvent);

    void delete(long id);

}
