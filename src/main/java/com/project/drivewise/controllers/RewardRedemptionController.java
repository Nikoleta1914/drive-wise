package com.project.drivewise.controllers;

import com.project.drivewise.entities.RewardRedemption;
import com.project.drivewise.repositories.RewardRedemptionRepository;
import com.project.drivewise.services.contracts.RewardRedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redemption")
public class RewardRedemptionController {

    private RewardRedemptionService rewardRedemptionService;

    @Autowired
    public RewardRedemptionController(RewardRedemptionService rewardRedemptionService) {
        this.rewardRedemptionService = rewardRedemptionService;
    }

    @GetMapping
    public List<RewardRedemption> findAll(){
        return rewardRedemptionService.findAll();
    }

    @PostMapping
    public RewardRedemption save(@RequestBody RewardRedemption rewardRedemption){
        return rewardRedemptionService.save(rewardRedemption);
    }

    @DeleteMapping
    public String delete(@PathVariable RewardRedemption rewardRedemption){
        rewardRedemptionService.delete(rewardRedemption);
        return "success.";
    }
}
