package com.example.baziproekt.service.impl;


import com.example.baziproekt.model.Company;
import com.example.baziproekt.model.Event;
import com.example.baziproekt.model.Person;
import com.example.baziproekt.model.exceptions.InvalidCompanyIdException;
import com.example.baziproekt.model.exceptions.InvalidEventIdException;
import com.example.baziproekt.model.exceptions.InvalidPersonIdException;
import com.example.baziproekt.repository.CompanyRepository;
import com.example.baziproekt.repository.EventRepository;
import com.example.baziproekt.repository.PersonRepository;
import com.example.baziproekt.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;

    public EventServiceImpl(EventRepository eventRepository, PersonRepository personRepository, CompanyRepository companyRepository) {
        this.eventRepository = eventRepository;
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Integer id) {
        return eventRepository.findById(id).orElseThrow(InvalidEventIdException::new);
    }

    @Override
    public Event create(String name, String venue, LocalDate event_date, String eventType, Integer budget, Integer companyId, Integer coordinatorId) {
        Company company = companyRepository.findById(companyId).orElseThrow(InvalidCompanyIdException::new);
        Person coordinator = personRepository.findById(coordinatorId).orElseThrow(InvalidPersonIdException::new);
        Event event = new Event(name, venue, event_date, eventType,budget,company,coordinator);
        return eventRepository.save(event);
    }
}
