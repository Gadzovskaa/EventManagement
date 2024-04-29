package com.example.baziproekt.service.views.impl;

import com.example.baziproekt.model.views.CoordinatorsOfEventsView;
import com.example.baziproekt.repository.views.CoordinatorsOfEventsViewRepository;
import com.example.baziproekt.service.views.CoordinatorsOfEventsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatorsOfEventsViewServiceImpl implements CoordinatorsOfEventsViewService {

    private final CoordinatorsOfEventsViewRepository coordinatorsOfEventsViewRepository;

    public CoordinatorsOfEventsViewServiceImpl(CoordinatorsOfEventsViewRepository coordinatorsOfEventsViewRepository) {
        this.coordinatorsOfEventsViewRepository = coordinatorsOfEventsViewRepository;
    }

    @Override
    public List<CoordinatorsOfEventsView> listAllCoordinatorsOfEvents() {
        return coordinatorsOfEventsViewRepository.findAllCoordinatorsOfEvents();
    }
}
