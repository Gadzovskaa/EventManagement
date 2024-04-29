package com.example.baziproekt.web;


import com.example.baziproekt.model.Person;
import com.example.baziproekt.service.CompanyService;
import com.example.baziproekt.service.EventService;
import com.example.baziproekt.service.PersonService;
import com.example.baziproekt.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class  PersonController {

    private final PersonService personService;
    private final CompanyService companyService;
    private final RoleService roleService;
    private final EventService eventService;

    public PersonController(PersonService personService, CompanyService companyService, RoleService roleService, EventService eventService) {
        this.personService = personService;
        this.companyService = companyService;
        this.roleService = roleService;
        this.eventService = eventService;
    }

    @GetMapping("/people")
    public String getPersonPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Person> persons = personService.listAll();
        model.addAttribute("persons", persons);
        return "people/personList";
    }

    @GetMapping("/people/register/{personID}")
    public String getRegistrationPage(@PathVariable Integer personID, Model model){
        model.addAttribute("companies", companyService.listAll());
        model.addAttribute("roles", roleService.listAll());
        model.addAttribute("events", eventService.listAll());
        model.addAttribute("person", personService.findById(personID));
        return "people/personRegisterForEvent";
    }

    @PostMapping("/people/registerToEvent/{personID}")
    public String registerToEvent(@PathVariable Integer personID,
                                  @RequestParam Integer roleId,
                                  @RequestParam Integer eventId
                           ) {
        personService.personRegistrationForEvent(personID,roleId,eventId);
        return "redirect:/people";
    }
    @GetMapping("/people/newPerson")
    public String getNewPersonForm(Model model) {
        model.addAttribute("companies", companyService.listAll());
        return "people/newPersonForm";
    }
    @PostMapping("/people/new/person")
    public String newEvent(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String phone,
                           @RequestParam Integer companyId) {
        personService.create(name,email,phone,companyService.findById(companyId));
        return "redirect:/people";
    }
}
