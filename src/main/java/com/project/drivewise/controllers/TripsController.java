package com.project.drivewise.controllers;

import com.project.drivewise.entities.Trips;
import com.project.drivewise.services.contracts.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-trips")
public class TripsController {

    private TripsService tripsService;

    @Autowired
    public TripsController(TripsService tripsService) {
        this.tripsService = tripsService;
    }

    @GetMapping
    public List<Trips> findAll(){
        return tripsService.findAll();
    }

    @GetMapping("/{tripsId}")
    public Optional<Trips> findById(@PathVariable long id){
        return tripsService.findById(id);
    }

    @PostMapping
    public Trips save(@RequestBody Trips trips){
        return tripsService.save(trips);
    }

    @DeleteMapping
    public String delete(@RequestBody Trips trips){
        tripsService.delete(trips);
        return "All trips has been deleted.";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        tripsService.deleteById(id);
        return "Trip has been deleted.";
    }

}
