package com.project.drivewise.repositories;

import com.project.drivewise.entities.PointsLedger;
import com.project.drivewise.entities.enums.PointsReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PointsLedgerRepository extends JpaRepository<PointsLedger, Long> {

    List<PointsLedger> findByUser_Id(UUID userId);
    List<PointsLedger> findByUser_IdAndReason(UUID userId, PointsReason reason);

    @Query("select coalesce(sum(p.pointsDelta),0) from PointsLedger p where p.user.id = :userId")
    int getUserBalance(@Param("userId") UUID userId);
}
