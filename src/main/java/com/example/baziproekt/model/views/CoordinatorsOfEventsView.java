package com.example.baziproekt.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "coordinatorsOfEvents")
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CoordinatorsOfEventsView {

    @Column(name = "coordinator_id")
    Integer coordinatorId;
    @Column(name = "person_name")
    String coordinatorName;
    @Column(name = "roletype")
    String roleType;
    @Id
    @Column(name = "event_id")
    Integer eventId;
    @Column(name = "event_name")
    String eventName;
    @Column(name = "company_id")
    Integer companyId;
    @Column(name = "company_name")
    String companyName;
}
