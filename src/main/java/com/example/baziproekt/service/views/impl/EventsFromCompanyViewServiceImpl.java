package com.example.baziproekt.service.views.impl;

import com.example.baziproekt.model.views.EventsFromCompanyView;

import com.example.baziproekt.repository.views.EventsFromCompanyViewRepository;
import com.example.baziproekt.service.views.EventsFromCompanyViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsFromCompanyViewServiceImpl implements EventsFromCompanyViewService {

    private final EventsFromCompanyViewRepository eventsFromCompanyViewRepository;

    public EventsFromCompanyViewServiceImpl(EventsFromCompanyViewRepository eventsFromCompanyViewRepository) {
        this.eventsFromCompanyViewRepository = eventsFromCompanyViewRepository;
    }


    @Override
    public List<EventsFromCompanyView> findAllCompanies() {
        return eventsFromCompanyViewRepository.findAllEventsFromCompany();
    }

    @Override
    public List<EventsFromCompanyView> findAllEventsFromCompanies(Integer companyId) {
        return eventsFromCompanyViewRepository.findEventsFromCompanyViewByCompanyId(companyId);
    }

}
