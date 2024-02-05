package com.example.baziproekt.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid")
    Integer id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String venue;
    @Column(name = "date")
    LocalDate date;
    @Column(nullable = false, name = "eventtype")
    String eventType;
    @Column(nullable = false)
    Integer budget;

    @ManyToOne
    @JoinColumn(name = "companyid")
    Company company;

    @ManyToOne
    @JoinColumn(name = "coordinatorid")
    Person coordinator;

    public Event(String name, String venue, LocalDate event_date, String eventType, Integer budget, Company company, Person coordinator) {
        this.name = name;
        this.venue = venue;
        this.date = event_date;
        this.eventType = eventType;
        this.budget = budget;
        this.company = company;
        this.coordinator = coordinator;
    }
}
