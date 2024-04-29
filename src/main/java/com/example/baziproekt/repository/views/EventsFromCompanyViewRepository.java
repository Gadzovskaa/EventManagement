package com.example.baziproekt.repository.views;

import com.example.baziproekt.model.views.EventsFromCompanyView;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsFromCompanyViewRepository extends JpaRepository<EventsFromCompanyView, Integer> {

    @Query(value = " SELECT * FROM public.\"eventsFromCompany\" ", nativeQuery = true)
    List<EventsFromCompanyView> findAllEventsFromCompany();

    @Query(value = "SELECT * FROM public.\"eventsFromCompany\" WHERE companyid = :companyId ", nativeQuery = true)
    List<EventsFromCompanyView> findEventsFromCompanyViewByCompanyId(Integer companyId);

}
