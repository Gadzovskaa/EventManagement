package com.example.baziproekt.service;

import com.example.baziproekt.model.reports.AllTimeAttendancePerCompany;
import com.example.baziproekt.model.reports.AvgAttendancePerCompany;

import java.util.List;

public interface AttendanceService {

    List<AllTimeAttendancePerCompany> listAllTimeAttendancePerCompany();
    List<AvgAttendancePerCompany> avgAttendancePerCompany();
}
