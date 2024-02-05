package com.example.baziproekt.service.views;

import com.example.baziproekt.model.views.EventAttendanceView;

import java.util.List;

public interface EventAttendanceViewService {

    List<EventAttendanceView> findAttendanceByEvent(Integer eventId);
}
