package com.example.baziproekt.model.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AvgAttendancePerCompany {
    String companyName;
    BigDecimal avgAttendance;
}
