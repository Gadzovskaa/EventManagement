package com.example.baziproekt.repository;


import com.example.baziproekt.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    @Query(value = "SELECT c.\"name\" AS companyName, " +
            "COUNT(a.id) AS totalAttendance " +
            "FROM company c " +
            "JOIN \"event\" e ON e.companyid = c.companyid " +
            "JOIN attendance a ON e.eventid = a.eventid " +
//            "JOIN attendance at ON e.companyid = at.eventid " +
            "GROUP BY c.\"name\" " +
            "ORDER BY totalAttendance DESC",
            nativeQuery = true)
    List<Object []> allTimeAttendancePerCompanyReport();

    @Query(value = "WITH EventAttendance AS (" +
            "    SELECT e.eventid, " +
            "           COUNT(DISTINCT a.personid) AS attendanceCount " +
            "    FROM attendance a " +
            "    JOIN \"event\" e ON e.eventid = a.eventid " +
            "    GROUP BY e.eventid" +
            ") " +
            "SELECT c.\"name\" AS companyName, " +
            "       AVG(ea.attendanceCount) AS avgAttendance " +
            "FROM company c " +
            "JOIN \"event\" e ON c.companyid = e.companyid " +
            "JOIN EventAttendance ea ON ea.eventid = e.eventid " +
            "GROUP BY c.\"name\"", nativeQuery = true)
    List<Object []> avgAttendancePerCompanyReport();
}
