package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.Reward;

import java.util.List;

public interface RewardService {

    List<Reward> findAll();

    Reward save(Reward reward);

    void deletedById(Long id);
}
