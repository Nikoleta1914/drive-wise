package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.DrivingEvent;

import java.util.List;
import java.util.UUID;

public interface DrivingEventService {

    List<DrivingEvent> findByUserId(UUID userId);

    List<DrivingEvent> findAll();

    DrivingEvent save(DrivingEvent drivingEvent);

    void delete(DrivingEvent drivingEvent);

}
