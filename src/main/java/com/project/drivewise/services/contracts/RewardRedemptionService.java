package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.RewardRedemption;

import java.util.List;

public interface RewardRedemptionService {

    List<RewardRedemption> findAll();

    RewardRedemption save(RewardRedemption rewardRedemption);

    void deleteById(Long id);
}
