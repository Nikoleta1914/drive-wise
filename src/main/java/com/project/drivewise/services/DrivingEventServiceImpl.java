package com.project.drivewise.services;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.repositories.DrivingEventRepository;
import com.project.drivewise.services.contracts.DrivingEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DrivingEventServiceImpl implements DrivingEventService {

    private Logger log = LoggerFactory.getLogger(DrivingEventServiceImpl.class);
    private DrivingEventRepository drivingEventRepository;

    @Override
    public List<DrivingEvent> findByUserId(UUID userId) {
       return drivingEventRepository.findByUserId(userId);
    }

    @Override
    public List<DrivingEvent> findAll() {
        return drivingEventRepository.findAll();
    }

    @Override
    public DrivingEvent save(DrivingEvent drivingEvent) {
        return drivingEventRepository.save(drivingEvent);
    }

    @Override
    public void delete(DrivingEvent drivingEvent) {
        drivingEventRepository.delete(drivingEvent);
        log.info("DrivingEvent deleted successfully");

    }


}
