package com.project.drivewise.controllers;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.services.contracts.DrivingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/driving-event")
public class DrivingEventController {

    private DrivingEventService drivingEventService;

    @Autowired
    public DrivingEventController(DrivingEventService drivingEventService){
        this.drivingEventService = drivingEventService;
    }


    @GetMapping
    public List<DrivingEvent> findAll(){
        return drivingEventService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<DrivingEvent> findByUserId(@PathVariable long userId){
        return drivingEventService.findByUserId(userId);
    }

    @GetMapping("/{id}")
    public Optional<DrivingEvent> findById(@PathVariable long id){
        return drivingEventService.findById(id);
    }

    @PostMapping
    public DrivingEvent save(@RequestBody DrivingEvent drivingEvent){
        return drivingEventService.save(drivingEvent);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        drivingEventService.delete(id);
        return "deleted.";
    }
}
