package com.project.drivewise.repositories;

import com.project.drivewise.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardsRepository extends JpaRepository<Reward, Long> {

    List<Reward> findByActiveTrue();
    List<Reward> findByActiveTrueAndPointsCostLessThanEqual(Integer pointsCost);
}
