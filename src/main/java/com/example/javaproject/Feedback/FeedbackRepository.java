package com.example.javaproject.Feedback;

import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
    public Long countById(Integer id);
}

