package com.example.baziproekt.service.views;

import com.example.baziproekt.model.views.EventsFromCompanyView;

import java.util.List;

public interface EventsFromCompanyViewService {

    List<EventsFromCompanyView> findAllCompanies();

    List<EventsFromCompanyView> findAllEventsFromCompanies(Integer companyId);
}
