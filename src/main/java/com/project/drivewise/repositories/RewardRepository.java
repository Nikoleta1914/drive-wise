package com.project.drivewise.repositories;

import com.project.drivewise.entities.Reward;
import com.project.drivewise.entities.RewardRedemption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RewardRepository extends JpaRepository<RewardRedemption, UUID> {

    List<Reward> findByActiveTrue();
    List<Reward> findByActiveTrueAndPointsCostLessThanEqual(Integer pointsCost);
}
