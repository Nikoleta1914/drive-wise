package com.project.drivewise.services;

import com.project.drivewise.entities.DrivingEvent;
import com.project.drivewise.repositories.DrivingEventRepository;
import com.project.drivewise.services.contracts.DrivingEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingEventServiceImpl implements DrivingEventService {

    private Logger log = LoggerFactory.getLogger(DrivingEventServiceImpl.class);
    private DrivingEventRepository drivingEventRepository;

    @Autowired
    public DrivingEventServiceImpl(DrivingEventRepository drivingEventRepository) {
        this.drivingEventRepository = drivingEventRepository;
    }

    @Override
    public List<DrivingEvent> findByUserId(long userId) {
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
    public void delete(long id) {
        drivingEventRepository.deleteById(id);
        log.info("DrivingEvent deleted successfully");

    }


}
