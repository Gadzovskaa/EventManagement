package com.example.baziproekt.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "personid")
    Integer id;
    @Column(nullable = false)
    @Getter
    String name;
    @Column(nullable = false)
    @Getter
    String email;
    @Getter
    String phone_number;

    @ManyToOne
    @JoinColumn(name = "companyid")
    Company company;

    @ManyToMany
    @JoinTable(
            name = "has_role",
            joinColumns = @JoinColumn(name = "personid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
    List<Role> rolesPersonHas;

    public Person(String personName, String personEmail, String phoneNumber) {
        rolesPersonHas = new ArrayList<>();
        this.name = personName;
        this.email = personEmail;
        this.phone_number = phoneNumber;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setRolesPersonHas(List<Role> rolesPersonHas) {
        this.rolesPersonHas = rolesPersonHas;
    }

    public List<Role> getRolesPersonHas() {
        return rolesPersonHas;
    }
}
