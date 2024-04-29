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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    Integer id;
    String description;

    @Column(name = "roletype")
    String roleType;

    @ManyToMany(mappedBy = "rolesPersonHas")
    List<Person> peopleWithThisRole;

    public Role(String description, String type) {
        peopleWithThisRole = new ArrayList<>();
        this.description = description;
        this.roleType = type;
    }
}
