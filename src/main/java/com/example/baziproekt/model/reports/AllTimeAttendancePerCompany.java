package com.example.baziproekt.model.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AllTimeAttendancePerCompany {
    String companyName;
    Long totalAttendance;
}
