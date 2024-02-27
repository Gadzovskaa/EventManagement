package com.example.baziproekt.service.impl;


import com.example.baziproekt.model.*;
import com.example.baziproekt.model.exceptions.InvalidCompanyIdException;
import com.example.baziproekt.model.exceptions.InvalidEventIdException;
import com.example.baziproekt.model.exceptions.InvalidPersonIdException;
import com.example.baziproekt.model.exceptions.InvalidRoleIdException;
import com.example.baziproekt.repository.*;
import com.example.baziproekt.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final EventRepository eventRepository;
    private final RoleRepository roleRepository;
    private final CompanyRepository companyRepository;
    private final AttendanceRepository attendanceRepository;

    public PersonServiceImpl(PersonRepository personRepositoryInterface, EventRepository eventRepository, RoleRepository roleRepository, CompanyRepository companyRepository, AttendanceRepository attendanceRepository) {
        this.personRepository = personRepositoryInterface;
        this.eventRepository = eventRepository;
        this.roleRepository = roleRepository;
        this.companyRepository = companyRepository;
        this.attendanceRepository = attendanceRepository;
    }



    @Override
    public List<Person> listAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Integer personID) {
        return personRepository.findById(personID).orElseThrow(InvalidPersonIdException::new);
    }

    @Override
    public Person create(String personName, String personEmail, String phoneNumber, Company company) {
        Person person = new Person(personName,personEmail,phoneNumber);
        person.setCompany(company);
        return personRepository.save(person);
    }

    @Override
    public void personRegistrationForEvent(Integer personID, Integer roleID, Integer eventID) {

        Person person = findById(personID);

        Role role = roleRepository.findById(roleID).orElseThrow(InvalidRoleIdException::new);
        person.getRolesPersonHas().add(role);

        Event event = eventRepository.findById(eventID).orElseThrow(InvalidEventIdException::new);
        Attendance attendance = new Attendance(role,person,event);
        attendanceRepository.save(attendance);
    }
}
