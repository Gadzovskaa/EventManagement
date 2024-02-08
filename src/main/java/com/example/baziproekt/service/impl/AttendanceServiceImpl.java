package com.example.baziproekt.service.impl;

import com.example.baziproekt.model.reports.AllTimeAttendancePerCompany;
import com.example.baziproekt.model.reports.AvgAttendancePerCompany;
import com.example.baziproekt.repository.AttendanceRepository;
import com.example.baziproekt.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AllTimeAttendancePerCompany> listAllTimeAttendancePerCompany() {
        List<Object []> result = attendanceRepository.allTimeAttendancePerCompanyReport();
        List<AllTimeAttendancePerCompany> reports = new ArrayList<>();
        for(Object [] row : result){
            String companyName = (String) row[0];
            Long allTimeAttendance = (Long) row[1];
            AllTimeAttendancePerCompany a = new AllTimeAttendancePerCompany(companyName,allTimeAttendance);
            reports.add(a);
        }
        return reports;
    }

    @Override
    public List<AvgAttendancePerCompany> avgAttendancePerCompany() {
        List<Object []> result = attendanceRepository.avgAttendancePerCompanyReport();
        List<AvgAttendancePerCompany> reports = new ArrayList<>();
        for(Object [] row : result){
            String companyName = (String) row[0];
            BigDecimal avgAtt = (BigDecimal) row[1];
            AvgAttendancePerCompany av = new AvgAttendancePerCompany(companyName, avgAtt);
            reports.add(av);
        }
        return reports;
    }
}
