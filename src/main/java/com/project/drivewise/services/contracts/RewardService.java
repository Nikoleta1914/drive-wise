package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.Reward;
import com.project.drivewise.entities.RewardRedemption;

import java.util.List;

public interface RewardService {

    List<Reward> findAll();

    Reward save(Reward reward);

    void delete(Reward reward);
}
