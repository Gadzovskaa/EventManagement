package com.example.baziproekt.web;

import com.example.baziproekt.model.Company;
import com.example.baziproekt.model.views.EventsFromCompanyView;
import com.example.baziproekt.service.CompanyService;
import com.example.baziproekt.service.EventService;
import com.example.baziproekt.service.views.CoordinatorsOfEventsViewService;
import com.example.baziproekt.service.views.EventAttendanceViewService;
import com.example.baziproekt.service.views.EventsFromCompanyViewService;
import com.example.baziproekt.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;
    private final CompanyService companyService;
    private final PersonService personService;

    private final EventsFromCompanyViewService eventsFromCompanyViewService;
    private final EventAttendanceViewService eventAttendanceViewService;
    private final CoordinatorsOfEventsViewService coordinatorsOfEventsViewService;


    public EventController(EventService eventService,
                           CompanyService companyService,
                           PersonService personService,
                           EventsFromCompanyViewService eventsFromCompanyViewService,
                           EventAttendanceViewService eventAttendanceViewService,
                           CoordinatorsOfEventsViewService coordinatorsOfEventsViewService) {
        this.eventService = eventService;
        this.companyService = companyService;
        this.personService = personService;
        this.eventsFromCompanyViewService = eventsFromCompanyViewService;
        this.eventAttendanceViewService = eventAttendanceViewService;
        this.coordinatorsOfEventsViewService = coordinatorsOfEventsViewService;
    }

    @GetMapping("/events")
    public String getPersonPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("events", eventService.listAll());

        return "events/eventList";
    }

    @GetMapping("/events/newEventForm")
    public String getNewEventForm(Model model) {

        model.addAttribute("companies", companyService.listAll());
        model.addAttribute("people", personService.listAll());
        return "events/newEventForm";
    }

    @PostMapping ("/events/create/new")
    public String newEvent(@RequestParam String name,
                           @RequestParam String venue,
                           @RequestParam LocalDate date,
                           @RequestParam String eventType,
                           @RequestParam Integer budget,
                           @RequestParam Integer companyId,
                           @RequestParam Integer coordinatorId) {
        eventService.create(name,venue,date,eventType,budget,companyId,coordinatorId);
    return "redirect:/events";
    }

    @GetMapping("/events/company/{id}")
    public String getNewEventForm(@PathVariable Integer id,
                                  Model model) {
        Company company = companyService.findById(id);
        List<EventsFromCompanyView> eventsFromCompany = eventsFromCompanyViewService.findAllEventsFromCompanies(id);
        model.addAttribute("eventsPerCompany", eventsFromCompany);
        model.addAttribute("company", company);
        return "events/eventsFromCompanyList";
    }

    @GetMapping("/events/attendance/{id}")
    public String getAttendanceForEvent (@PathVariable Integer id,
                                         Model model) {
        model.addAttribute("people", eventAttendanceViewService.findAttendanceByEvent(id));
        return "events/eventAttendance";
    }

    @GetMapping("/events/coordinators")
    public String getAllCoordinators (Model model) {
        model.addAttribute("coords", coordinatorsOfEventsViewService.listAllCoordinatorsOfEvents());
        return "events/eventCoordinators";
    }
}
