package com.example.baziproekt.web;

import com.example.baziproekt.model.Company;
import com.example.baziproekt.model.Rating;
import com.example.baziproekt.service.AttendanceService;
import com.example.baziproekt.service.CompanyService;
import com.example.baziproekt.service.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CompanyController {

    private final CompanyService companyService;
    private final AttendanceService attendanceService;
    private final RatingService ratingService;

    public CompanyController(CompanyService companyService, AttendanceService attendanceService, RatingService ratingService) {
        this.companyService = companyService;
        this.attendanceService = attendanceService;
        this.ratingService = ratingService;
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
                           @RequestParam String email) {
        companyService.create(name,email);
        return "redirect:/companies";
    }

    @GetMapping("/companies/allTimeAttendance")
    public String getAllTimeAttendance( Model model) {
        model.addAttribute("allTimeAtt", attendanceService.listAllTimeAttendancePerCompany());
        return "companies/allTimeAttendancePerCompany";
    }

    @GetMapping("/companies/avgAttendance")
    public String getAvgAttendance( Model model) {
        model.addAttribute("avgAtt", attendanceService.avgAttendancePerCompany());
        return "companies/avgAttendancePerCompany";
    }


    @PostMapping("/companies/{id}/rate")
    public String rateCompany(@PathVariable Integer id,
                              @RequestParam Integer rating) {
        Company company = this.companyService.findById(id);
        Rating rating1 = this.ratingService.addRating(rating);
        List<Rating> companyRatings = company.getRatings();
        companyRatings.add(rating1);
        this.companyService.updateRatings(id, companyRatings);
        return "redirect:/companies";
    }
}
