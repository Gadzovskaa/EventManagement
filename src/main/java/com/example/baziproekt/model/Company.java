package com.example.baziproekt.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToMany(fetch = FetchType.EAGER)
    List<Rating> ratings;
    Double averageRating;

    public Company(String companyName, String companyEmail) {
        this.name = companyName;
        this.email = companyEmail;
    }

    public Double getAverageRating() {
        if(this.ratings.isEmpty())
            return 0.0;
        else {
            int sum = this.ratings.stream().mapToInt(Rating::getRating).sum();
            return ((double) sum / this.ratings.size());
        }
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
