package com.example.baziproekt.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyid")
    Integer id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;

    public Company(String companyName, String companyEmail) {
        this.name = companyName;
        this.email = companyEmail;
    }
}
