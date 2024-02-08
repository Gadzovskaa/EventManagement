package com.example.baziproekt.web;

import com.example.baziproekt.service.AttendanceService;
import com.example.baziproekt.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController {

    private final CompanyService companyService;
    private final AttendanceService attendanceService;

    public CompanyController(CompanyService companyService, AttendanceService attendanceService) {
        this.companyService = companyService;
        this.attendanceService = attendanceService;
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
}
