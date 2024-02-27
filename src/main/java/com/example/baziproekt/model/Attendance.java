package com.example.baziproekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor

@Getter
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "roleid")
    Role attendedAsRole;

    @ManyToOne
    @JoinColumn(name = "personid")
    Person personAttended;

    @ManyToOne
    @JoinColumn(name = "eventid")
    Event eventAttended;

    public Attendance(Role attendedAsRole, Person personAttended, Event eventAttended) {
        this.attendedAsRole = attendedAsRole;
        this.personAttended = personAttended;
        this.eventAttended = eventAttended;
    }
}
