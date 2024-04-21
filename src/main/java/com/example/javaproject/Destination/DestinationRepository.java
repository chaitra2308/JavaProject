package com.example.javaproject.Destination;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface DestinationRepository extends CrudRepository<Destination, Integer> {
    //Optional<Destination> findById(Integer id);
}

