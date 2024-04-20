package com.example.javaproject.Transport;

import com.example.javaproject.Accommodation.Accommodation;
import jakarta.persistence.*;

@Entity
@Table(name = "Transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String type; // Type of vehicle: car, mini van, bus, etc.

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    // Constructors, getters, and setters

    public Transport() {
        // Default constructor
    }

    public Transport(String type, String phoneNumber) {
        this.type = type;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
