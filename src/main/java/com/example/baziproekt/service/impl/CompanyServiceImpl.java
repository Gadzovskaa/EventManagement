package com.example.baziproekt.service.impl;


import com.example.baziproekt.model.Company;
import com.example.baziproekt.model.exceptions.InvalidCompanyIdException;
import com.example.baziproekt.repository.CompanyRepository;
import com.example.baziproekt.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
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
}
