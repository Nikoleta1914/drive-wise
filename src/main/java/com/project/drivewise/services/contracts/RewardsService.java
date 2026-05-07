package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.Reward;

import java.util.List;

public interface RewardsService {

    List<Reward> findAll();

    Reward save(Reward reward);

    void delete(Reward reward);

    void deletedById(Long id);
}
