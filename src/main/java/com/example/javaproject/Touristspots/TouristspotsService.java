package com.example.javaproject.Touristspots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TouristspotsService {

    @Autowired
    private TouristspotsRepository touristspotsRepository;

    public List<Touristspots> listAll() {
        return (List<Touristspots>) touristspotsRepository.findAll();
    }

    public Touristspots getById(Integer id) throws TouristspotsNotFoundException {
        Optional<Touristspots> result = touristspotsRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new TouristspotsNotFoundException.Builder()
                .withMessage("Touristspot not found for id: " + id)
                .build();
    }
}

