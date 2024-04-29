package com.example.baziproekt.repository;


import com.example.baziproekt.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(value = "SELECT c.\"name\" AS companyName, " +
            "COUNT(e.eventid) AS numberOfEvents, " +
            "EXTRACT(MONTH FROM e.\"date\") AS eventMonth, " +
            "EXTRACT(YEAR FROM e.\"date\") AS eventYear " +
            "FROM \"event\" e " +
            "JOIN company c ON e.companyid = c.companyid " +
            "GROUP BY c.\"name\", eventMonth, eventYear " +
            "ORDER BY eventMonth DESC", nativeQuery = true)
    List<Object []> getNumberOfEventsPerCompanyReport();


}
