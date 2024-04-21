package com.example.javaproject.TripSummary;

import com.example.javaproject.Feedback.Feedback;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripSummaryRepository extends CrudRepository<TripSummary, Integer>{
    public Long countById(Integer id);
    /*
    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.accommodations WHERE ts.destId = 0")
    List<TripSummary> findAllWithAccommodations();

    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.modeOfTransport WHERE ts.destId = 0")
    List<TripSummary> findAllWithModeOfTransport();

    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.touristSpots WHERE ts.destId = 0")
    List<TripSummary> findAllWithTouristSpots();*/
    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.accommodations WHERE ts.destId = 3")
    List<TripSummary> findAllWithAccommodations();

    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.modeOfTransport WHERE ts.destId = 3")
    List<TripSummary> findAllWithModeOfTransport();

    @Query("SELECT ts FROM TripSummary ts LEFT JOIN FETCH ts.touristSpots WHERE ts.destId = 3")
    List<TripSummary> findAllWithTouristSpots();


}


