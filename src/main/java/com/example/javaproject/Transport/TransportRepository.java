package com.example.javaproject.Transport;

import org.springframework.data.repository.CrudRepository;

public interface TransportRepository extends CrudRepository<Transport, Integer> {
    Long countById(Integer id);
}
