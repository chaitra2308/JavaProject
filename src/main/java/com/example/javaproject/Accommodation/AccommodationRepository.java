package com.example.javaproject.Accommodation;

import org.springframework.data.repository.CrudRepository;

public interface AccommodationRepository extends CrudRepository<Accommodation, Integer> {
    public Long countById(Integer id);
}
