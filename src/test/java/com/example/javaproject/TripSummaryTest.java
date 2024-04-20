package com.example.javaproject;

import com.example.javaproject.TripSummary.TripSummary;
import com.example.javaproject.TripSummary.TripSummaryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TripSummaryTest {
    @Autowired
    private TripSummaryRepository TSRepo;

    @Test
    public void testListAllTripSummaries() {
        // Fetch trip summaries with accommodations
        List<TripSummary> tripSummariesWithAccommodations = TSRepo.findAllWithAccommodations();
        System.out.println("Trip Summaries with Accommodations:");
        printTripSummaries(tripSummariesWithAccommodations);

        // Fetch trip summaries with mode of transport
        List<TripSummary> tripSummariesWithModeOfTransport = TSRepo.findAllWithModeOfTransport();
        System.out.println("\nTrip Summaries with Mode of Transport:");
        printTripSummaries(tripSummariesWithModeOfTransport);

        // Fetch trip summaries with tourist spots
        List<TripSummary> tripSummariesWithTouristSpots = TSRepo.findAllWithTouristSpots();
        System.out.println("\nTrip Summaries with Tourist Spots:");
        printTripSummaries(tripSummariesWithTouristSpots);
    }

    // Helper method to print trip summaries
    private void printTripSummaries(List<TripSummary> tripSummaries) {
        for (TripSummary tripSummary : tripSummaries) {
            System.out.println("Trip Summary ID: " + tripSummary.getId());
            System.out.println("Destination: " + tripSummary.getDestination());
            System.out.println("Duration: " + tripSummary.getDuration());
            System.out.println("Trip Date: " + tripSummary.getTripDate());
            System.out.println("User ID: " + tripSummary.getUserId());

            // Print associated entities if available
            if (tripSummary.getAccommodations() != null) {
                System.out.println("Accommodations: " + tripSummary.getAccommodations());
            }
            if (tripSummary.getModeOfTransport() != null) {
                System.out.println("Mode of Transport: " + tripSummary.getModeOfTransport());
            }
            if (tripSummary.getTouristSpots() != null) {
                System.out.println("Tourist Spots: " + tripSummary.getTouristSpots());
            }

            System.out.println(); // Add a newline for clarity between trip summaries
        }
    }


}
