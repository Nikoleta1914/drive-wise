package com.project.drivewise.repositories;

import com.project.drivewise.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardsRepository extends JpaRepository<Reward, Long> {

    List<Reward> findByActiveTrue();
    List<Reward> findByActiveTrueAndPointsCostLessThanEqual(Integer pointsCost);
}
