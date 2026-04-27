package com.project.drivewise.repositories;

import com.project.drivewise.entities.RewardRedemption;
import com.project.drivewise.entities.enums.RedemptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RedemptionRepository extends JpaRepository<RewardRedemption, UUID> {

    List<RewardRedemption> findByUser_Id(UUID userId);
    List<RewardRedemption> findByUser_IdAndStatus(UUID userId, RedemptionStatus status);
    List<RewardRedemption> findByReward_Id(UUID rewardId);
}
