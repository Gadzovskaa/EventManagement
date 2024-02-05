package com.example.baziproekt.service;



import com.example.baziproekt.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    List<Event> listAll();
    Event findById(Integer id);
    Event create(String name, String venue, LocalDate event_date, String eventType, Integer budget, Integer companyId, Integer coordinatorId);
}
