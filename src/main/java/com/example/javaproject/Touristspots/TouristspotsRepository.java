package com.example.javaproject.Touristspots;

import org.springframework.data.repository.CrudRepository;

public interface TouristspotsRepository extends CrudRepository<Touristspots, Integer> {
    // No additional methods needed, CRUD operations are inherited from CrudRepository
}
