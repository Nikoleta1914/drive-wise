package com.project.drivewise.controllers;

import com.project.drivewise.entities.Reward;
import com.project.drivewise.services.contracts.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private RewardsService rewardsService;

    @Autowired
    public RewardController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping
    public List<Reward> findAll(){
        return rewardsService.findAll();
    }

    @PostMapping
    public Reward save(@RequestBody Reward reward){
        return rewardsService.save(reward);
    }

    @DeleteMapping
    public String delete(@PathVariable Reward reward){
        rewardsService.delete(reward);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        rewardsService.deletedById(id);
        return "success";
    }


}
