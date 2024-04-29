package com.example.baziproekt.service.impl;


import com.example.baziproekt.model.Company;
import com.example.baziproekt.model.Rating;
import com.example.baziproekt.model.exceptions.InvalidCompanyIdException;
import com.example.baziproekt.repository.CompanyRepository;
import com.example.baziproekt.service.CompanyService;
import com.example.baziproekt.service.RatingService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final RatingService ratingService;

    public CompanyServiceImpl(CompanyRepository companyRepository, RatingService ratingService) {
        this.companyRepository = companyRepository;
        this.ratingService = ratingService;
    }

    @Override
    public List<Company> listAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company create(String name, String email) {
        Company company = new Company(name,email);
        return companyRepository.save(company);
    }

    @Override
    public Company findById(Integer id) {
        return companyRepository.findById(id).orElseThrow(InvalidCompanyIdException::new);
    }

    @Override
    public Company updateRatings(Integer id, List<Rating> ratings) {
        Company company = this.findById(id);
        company.setRatings(ratings);
        return this.companyRepository.save(company);
    }

}
