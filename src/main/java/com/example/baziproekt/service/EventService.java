package com.example.baziproekt.service;



import com.example.baziproekt.model.Event;
import com.example.baziproekt.model.reports.NumEventsPerCompany;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    List<Event> listAll();
    Event create(String name, String venue, LocalDate event_date, String eventType, Integer budget, Integer companyId, Integer coordinatorId);

    List<NumEventsPerCompany> numEventsPerCompanyReport();
}
