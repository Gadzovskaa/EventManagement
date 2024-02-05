package com.example.baziproekt.web;

import com.example.baziproekt.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public String getPersonPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("companies", companyService.listAll());
        return "companies/companyList";
    }

    @GetMapping("/companies/newCompanyForm")
    public String getNewEventForm() {
        return "companies/newCompanyForm";
    }

    @PostMapping("/companies/create/new")
    public String newEvent(@RequestParam String name,
                           @RequestParam String email,
                           Model model) {
        companyService.create(name,email);
        return "redirect:/companies";
    }
}
