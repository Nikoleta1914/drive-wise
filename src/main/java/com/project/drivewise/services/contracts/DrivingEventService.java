package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.DrivingEvent;

import java.util.List;

public interface DrivingEventService {

    List<DrivingEvent> findByUserId(long userId);

    List<DrivingEvent> findAll();

    DrivingEvent save(DrivingEvent drivingEvent);

    void delete(long id);

}
