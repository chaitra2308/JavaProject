package com.example.javaproject.Touristspots;

public class TouristspotsNotFoundException extends Throwable {
    public TouristspotsNotFoundException(String message) {
        super(message);
    }

    public static class Builder {
        private String message;

        public Builder() {}

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public TouristspotsNotFoundException build() {
            return new TouristspotsNotFoundException(this.message);
        }
    }
}
