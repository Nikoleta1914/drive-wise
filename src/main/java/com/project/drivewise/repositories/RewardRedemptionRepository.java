package com.project.drivewise.repositories;

import com.project.drivewise.entities.RewardRedemption;
import com.project.drivewise.entities.enums.RedemptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRedemptionRepository extends JpaRepository<RewardRedemption, Long> {

    List<RewardRedemption> findByUser_Id(long userId);
    List<RewardRedemption> findByUser_IdAndStatus(long userId, RedemptionStatus status);
    List<RewardRedemption> findByReward_Id(long rewardId);
}
