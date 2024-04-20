package com.example.javaproject.TripSummary;

import com.example.javaproject.Feedback.Feedback;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripSummaryRepository extends CrudRepository<TripSummary, Integer>{
    public Long countById(Integer id);
    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.accommodations")
    List<TripSummary> findAllWithAccommodations();

    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.modeOfTransport")
    List<TripSummary> findAllWithModeOfTransport();

    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.touristSpots")
    List<TripSummary> findAllWithTouristSpots();

}


