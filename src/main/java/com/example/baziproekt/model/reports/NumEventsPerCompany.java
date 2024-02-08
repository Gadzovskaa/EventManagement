package com.example.baziproekt.model.reports;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.YearMonth;

@Data
@NoArgsConstructor
@Getter
public class NumEventsPerCompany {
    String companyName;
    Long numberOfEvents;
    Integer eventMonth;
    Integer eventYear;
    YearMonth monthAndYear;

    public NumEventsPerCompany(String companyName, Long numEvents, Integer month, Integer year) {
        this.companyName = companyName;
        this.numberOfEvents = numEvents;
        this.eventMonth = month;
        this.eventYear = year;
        monthAndYear = YearMonth.of(year,month);
    }
}
