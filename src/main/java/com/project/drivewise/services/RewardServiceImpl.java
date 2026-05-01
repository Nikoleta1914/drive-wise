package com.project.drivewise.services;

import com.project.drivewise.entities.Reward;
import com.project.drivewise.entities.RewardRedemption;
import com.project.drivewise.repositories.RewardRepository;
import com.project.drivewise.services.contracts.RewardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

    private RewardRepository rewardRepository;

    @Override
    public List<Reward> findAll() {
        return rewardRepository.findAll();
    }

    @Override
    public Reward save(Reward reward) {
        return rewardRepository.save(reward);
    }

    @Override
    public void delete(Reward reward) {
        rewardRepository.delete(reward);

    }
}
