package com.example.javaproject.Accommodation;

import jakarta.persistence.*;

@Entity
@Table(name="Accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String location;

    @Column(nullable=false)
    private Double price;

    @Column(nullable=false)
    private Integer capacity;

    @Column(nullable=false)
    private String amenities;

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", amenities='" + amenities + '\'' +
                '}';
    }

    public Accommodation() {
        // Default constructor required by JPA
    }

    public Accommodation(String name, String location, Double price, Integer capacity, String amenities) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.capacity = capacity;
        this.amenities = amenities;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}
