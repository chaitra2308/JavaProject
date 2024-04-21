package com.example.javaproject.Touristspots;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TouristspotsRepository extends CrudRepository<Touristspots, Integer> {
    List<Touristspots> findByDestId(Integer destId);
}