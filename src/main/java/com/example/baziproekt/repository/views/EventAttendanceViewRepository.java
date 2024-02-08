package com.example.baziproekt.repository.views;

import com.example.baziproekt.model.views.EventAttendanceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventAttendanceViewRepository extends JpaRepository<EventAttendanceView, Integer> {

    @Query(value = " SELECT * FROM public.\"eventattendance\" ", nativeQuery = true)
    List<EventAttendanceView> findAttendancePerEvent();
    @Query(value = " SELECT * FROM public.\"eventattendance\" WHERE event_id = :eventId ", nativeQuery = true)
    List<EventAttendanceView> findEventAttendanceViewByEventId(Integer eventId);

}
