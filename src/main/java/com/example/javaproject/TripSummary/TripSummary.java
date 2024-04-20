package com.example.javaproject.TripSummary;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="TripSummary")
public class TripSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private Integer userId;

    @Column(nullable=false)
    @Temporal(TemporalType.DATE) // Map to DATE type in MySQL
    private Date tripDate;

    @Column(nullable=false)
    private String destination;

    @Column(nullable=false)
    private Integer duration;

    @ElementCollection
    private List<String> touristSpots;

    @ElementCollection
    private List<String> accommodations;

    @ElementCollection
    private List<String> modeOfTransport;

    @Override
    public String toString() {
        return "TripSummary{" +
                "id=" + id +
                ", userId=" + userId +
                ", tripDate=" + tripDate +
                ", destination='" + destination + '\'' +
                ", duration=" + duration +
                ", touristSpots=" + touristSpots +
                ", accommodations=" + accommodations +
                ", modeOfTransport=" + modeOfTransport +
                '}';
    }

    // Constructors, getters, and setters
    public TripSummary() {
        // Default constructor required by JPA
    }

    public TripSummary(Integer userId, Date tripDate, String destination, Integer duration,
                       List<String> touristSpots, List<String> accommodations, List<String> modeOfTransport) {
        this.userId = userId;
        this.tripDate = tripDate;
        this.destination = destination;
        this.duration = duration;
        this.touristSpots = touristSpots;
        this.accommodations = accommodations;
        this.modeOfTransport = modeOfTransport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<String> getTouristSpots() {
        return touristSpots;
    }

    public void setTouristSpots(List<String> touristSpots) {
        this.touristSpots = touristSpots;
    }

    public List<String> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<String> accommodations) {
        this.accommodations = accommodations;
    }

    public List<String> getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(List<String> modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }
}
