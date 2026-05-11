package com.project.drivewise.repositories;

import com.project.drivewise.entities.TelemetryPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface TelemetryPointsRepository extends JpaRepository<TelemetryPoints, Long> {

    List<TelemetryPoints> findByTrip_Id(long tripId);
List<TelemetryPoints> findByTrip_IdAndRecordedAtBetween(long tripId,
                                                        OffsetDateTime from, OffsetDateTime to);
}
