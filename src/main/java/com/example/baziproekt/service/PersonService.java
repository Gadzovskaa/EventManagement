package com.example.baziproekt.service;



import com.example.baziproekt.model.Company;
import com.example.baziproekt.model.Event;
import com.example.baziproekt.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    List<Person> listAll();

    Person findById(Integer personID);

    Person create(String personName, String personEmail, String phoneNumber, Company company);


    void personRegistrationForEvent(Integer personID, Integer roleID, Integer eventID);
}
