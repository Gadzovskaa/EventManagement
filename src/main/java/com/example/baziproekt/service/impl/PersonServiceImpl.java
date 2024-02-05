package com.example.baziproekt.service.impl;


import com.example.baziproekt.model.Person;
import com.example.baziproekt.repository.PersonRepository;
import com.example.baziproekt.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepositoryInterface;

    public PersonServiceImpl(PersonRepository personRepositoryInterface) {
        this.personRepositoryInterface = personRepositoryInterface;
    }

    @Override
    public List<Person> listAll() {
        return personRepositoryInterface.findAll();
    }
}
