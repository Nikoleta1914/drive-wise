package com.project.drivewise.services;

import com.project.drivewise.entities.Reward;
import com.project.drivewise.repositories.RewardsRepository;
import com.project.drivewise.services.contracts.RewardsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsServiceImpl implements RewardsService {

    private RewardsRepository rewardRepository;

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

    @Override
    public void deletedById(Long id) {
        rewardRepository.deleteById(id);
    }
}
