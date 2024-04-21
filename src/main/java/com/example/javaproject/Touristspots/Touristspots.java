package com.example.javaproject.Touristspots;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Touristspots {
    @Id
    private Integer id;
    private Integer destId;
    private String name;
    private String text;
    private int rating;

    public Touristspots() {
    }

    private Touristspots(Builder builder) {
        this.id = builder.id;
        this.destId = builder.destId;
        this.name = builder.name;
        this.text = builder.text;
        this.rating = builder.rating;
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public Integer getDestId() {
        return destId;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    // Builder class
    public static class Builder {
        private Integer id;
        private Integer destId;
        private String name;
        private String text;
        private int rating;

        public Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withDestId(Integer destId) {
            this.destId = destId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Builder withRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Touristspots build() {
            return new Touristspots(this);
        }
    }
}
