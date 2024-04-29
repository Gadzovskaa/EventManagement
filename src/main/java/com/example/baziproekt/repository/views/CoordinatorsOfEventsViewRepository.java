package com.example.baziproekt.repository.views;

import com.example.baziproekt.model.views.CoordinatorsOfEventsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordinatorsOfEventsViewRepository extends JpaRepository<CoordinatorsOfEventsView, Integer> {

    @Query(value = " SELECT * FROM public.\"coordinatorsofevents\" ", nativeQuery = true)
    List<CoordinatorsOfEventsView> findAllCoordinatorsOfEvents();
}
