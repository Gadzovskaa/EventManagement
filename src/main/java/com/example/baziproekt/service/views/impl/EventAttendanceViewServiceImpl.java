package com.example.baziproekt.service.views.impl;

import com.example.baziproekt.model.views.EventAttendanceView;
import com.example.baziproekt.repository.views.EventAttendanceViewRepository;
import com.example.baziproekt.service.views.EventAttendanceViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAttendanceViewServiceImpl implements EventAttendanceViewService {

    private final EventAttendanceViewRepository eventAttendanceViewRepository;

    public EventAttendanceViewServiceImpl(EventAttendanceViewRepository eventAttendanceViewRepository) {
        this.eventAttendanceViewRepository = eventAttendanceViewRepository;
    }

    @Override
    public List<EventAttendanceView> findAttendanceByEvent(Integer eventId) {
        return eventAttendanceViewRepository.findEventAttendanceViewByEventId(eventId);
    }
}
