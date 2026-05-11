package com.project.drivewise.controllers;

import com.project.drivewise.entities.Reward;
import com.project.drivewise.services.contracts.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<Reward> findAll(){
        return rewardService.findAll();
    }

    @PostMapping
    public Reward save(@RequestBody Reward reward){
        return rewardService.save(reward);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        rewardService.deletedById(id);
        return "success";
    }


}
