package com.project.drivewise.repositories;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.entities.enums.DrivingEventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface DrivingEventRepository extends JpaRepository<DrivingEvent, Long> {

    List<DrivingEvent> findByUserId(long userId);

    List<DrivingEvent> findByTripId(long tripId);

    List<DrivingEvent> findByEventType(DrivingEventType eventType);

    List<DrivingEvent> findByEventTimeBetween(OffsetDateTime from,
                                              OffsetDateTime to);

    List<DrivingEvent> findByUserIdAndEventTypeAndEventTimeBetween(
            long userId, DrivingEventType eventType, OffsetDateTime from,
            OffsetDateTime to
    );
}
