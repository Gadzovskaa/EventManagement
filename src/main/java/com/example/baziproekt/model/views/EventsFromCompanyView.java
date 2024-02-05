package com.example.baziproekt.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Table(name = "eventsFromCompany")
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EventsFromCompanyView {
    @Id
    @Column(name = "companyid")
    Integer companyId;

    @Column(name = "eventname")
    String eventName;

    @Column(name = "eventvenue")
    String eventVenue;

    @Column(name = "eventdate")
    LocalDate eventDate;

    @Column(name = "eventtype")
    String eventType;

    @Column(name = "companyname")
    String companyName;

    @Column(name = "eventbudget")
    Integer eventBudget;
}
