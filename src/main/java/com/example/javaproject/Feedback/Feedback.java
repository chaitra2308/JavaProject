package com.example.javaproject.Feedback;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private Integer userId;

    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable=false)
    private Integer rating;

    @Column(nullable=false)
    private String comments;

    @Column(nullable=false)
    private String experience;

    @Column(nullable=false)
    private String destination;

    @Column(nullable=false)
    private String improvementSuggestions;

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", experience='" + experience + '\'' +
                ", destination='" + destination + '\'' +
                ", improvementSuggestions='" + improvementSuggestions + '\'' +
                '}';
    }
    public Feedback() {
        // Default constructor required by JPA
    }

    public Feedback(Integer userId, Date date, Integer rating, String comments, String experience,
                    String destination, String improvementSuggestions) {
        this.userId = userId;
        this.date = date;
        this.rating = rating;
        this.comments = comments;
        this.experience = experience;
        this.destination = destination;
        this.improvementSuggestions = improvementSuggestions;
    }

    // Getters and setters
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getImprovementSuggestions() {
        return improvementSuggestions;
    }

    public void setImprovementSuggestions(String improvementSuggestions) {
        this.improvementSuggestions = improvementSuggestions;
    }
}
