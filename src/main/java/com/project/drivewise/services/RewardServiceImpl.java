package com.project.drivewise.services;

import com.project.drivewise.entities.Reward;
import com.project.drivewise.repositories.RewardsRepository;
import com.project.drivewise.services.contracts.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

    private final RewardsRepository rewardRepository;

    @Autowired
    public RewardServiceImpl(RewardsRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @Override
    public List<Reward> findAll() {
        return rewardRepository.findAll();
    }

    @Override
    public Reward save(Reward reward) {
        return rewardRepository.save(reward);
    }

    @Override
    public void deletedById(Long id) {
        rewardRepository.deleteById(id);
    }
}
