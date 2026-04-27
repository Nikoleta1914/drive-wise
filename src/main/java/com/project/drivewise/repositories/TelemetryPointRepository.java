package com.project.drivewise.repositories;

import com.project.drivewise.entities.TelemetryPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface TelemetryPointRepository extends JpaRepository<TelemetryPoint, Long> {

    List<TelemetryPoint> findByTrip_Id(UUID tripId);
List<TelemetryPoint> findByTrip_IdAndRecordedAtBetween(UUID tripId,
                                                       OffsetDateTime from,OffsetDateTime to);
}
