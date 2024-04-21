package com.example.javaproject.Destination;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String destName;

    @Column(nullable=true)
    private byte[] picture;

    @Column(nullable=false)
    private String text;

    // Private constructor to prevent direct instantiation
    private Destination() {}

    // Getters

    public Integer getId() {
        return id;
    }

    public String getDestName() {
        return destName;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getText() {
        return text;
    }

    // Builder class
    public static class Builder {
        private Integer id;
        private String destName;
        private byte[] picture;
        private String text;

        public Builder() {}

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withDestName(String destName) {
            this.destName = destName;
            return this;
        }

        public Builder withPicture(byte[] picture) {
            this.picture = picture;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Destination build() {
            Destination destination = new Destination();
            destination.id = this.id;
            destination.destName = this.destName;
            destination.picture = this.picture;
            destination.text = this.text;
            return destination;
        }
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", destName='" + destName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
