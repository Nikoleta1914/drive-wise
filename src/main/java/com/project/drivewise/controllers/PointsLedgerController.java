package com.project.drivewise.controllers;


import com.project.drivewise.entities.PointsLedger;
import com.project.drivewise.repositories.PointsLedgerRepository;
import com.project.drivewise.services.contracts.PointsLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/points-ledger")
public class PointsLedgerController {

    private PointsLedgerService pointsLedgerService;

    @Autowired
    public PointsLedgerController(PointsLedgerService pointsLedgerService) {
        this.pointsLedgerService = pointsLedgerService;
    }

    @GetMapping
    public List<PointsLedger> findAll(){
        return pointsLedgerService.findAll();
    }

    @GetMapping("/{Id}")
    public Optional<PointsLedger> findById(@PathVariable Long id){
        return pointsLedgerService.findById(id);
    }

    @PostMapping
    public PointsLedger save(@RequestBody PointsLedger pointsLedger){
        return pointsLedgerService.save(pointsLedger);
    }

    @DeleteMapping
    public String delete(@PathVariable PointsLedger pointsLedger){
        pointsLedgerService.delete(pointsLedger);
        return "successfully deleted.";
    }

}
