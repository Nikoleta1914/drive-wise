package com.project.drivewise.repositories;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.entities.enums.DrivingEventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface DrivingEventRepository extends JpaRepository<DrivingEvent, Long> {

    List<DrivingEvent> findByUser_Id(UUID userId);

    List<DrivingEvent> findByTrip_Id(UUID tripId);

    List<DrivingEvent> findByEventType(DrivingEventType eventType);

    List<DrivingEvent> findByEventTimeBetween(OffsetDateTime from,
                                              OffsetDateTime to);

    List<DrivingEvent> findByUser_IdAndEventTypeAndEventTimeBetween(
            UUID userId, DrivingEventType eventType, OffsetDateTime from,
            OffsetDateTime to
    );
}
