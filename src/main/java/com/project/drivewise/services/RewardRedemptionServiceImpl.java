package com.project.drivewise.services;

import com.project.drivewise.entities.RewardRedemption;
import com.project.drivewise.repositories.RewardRedemptionRepository;
import com.project.drivewise.services.contracts.RewardRedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardRedemptionServiceImpl implements RewardRedemptionService {

    private final RewardRedemptionRepository rewardRedemptionRepository;

    @Autowired
    public RewardRedemptionServiceImpl(RewardRedemptionRepository rewardRedemptionRepository) {
        this.rewardRedemptionRepository = rewardRedemptionRepository;
    }

    @Override
    public List<RewardRedemption> findAll() {
        return rewardRedemptionRepository.findAll();
    }

    @Override
    public RewardRedemption save(RewardRedemption rewardRedemption) {
        return rewardRedemptionRepository.save(rewardRedemption);
    }

    @Override
    public void delete(RewardRedemption rewardRedemption) {
        rewardRedemptionRepository.delete(rewardRedemption);
    }
}
