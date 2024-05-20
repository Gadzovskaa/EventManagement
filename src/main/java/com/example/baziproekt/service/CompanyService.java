package com.example.baziproekt.service;
import com.example.baziproekt.model.Company;
import com.example.baziproekt.model.Rating;

import java.util.List;

public interface CompanyService {

    List<Company> listAll();

    Company create(String name, String email);

    Company findById(Integer id);

    Company updateRatings(Integer id, List<Rating> ratings);
}
