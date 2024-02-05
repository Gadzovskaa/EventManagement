package com.example.baziproekt.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "eventattendance")
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EventAttendanceView {
    @Id
    @Column(name = "attendance_id")
    Integer attendanceId;
    @Column(name = "person_name")
    String personName;
    @Column(name = "person_id")
    Integer personId;
    @Column(name = "role_type")
    String roleType;
    @Column(name = "event_name")
    String eventName;
    @Column(name = "event_id")
    Integer eventId;
    @Column(name = "company_id")
    Integer companyId;
    @Column(name = "company_name")
    String companyName;
}
