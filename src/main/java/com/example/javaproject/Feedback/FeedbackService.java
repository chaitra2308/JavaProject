package com.example.javaproject.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.*;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;


    public List<Feedback> listAll() {
        return (List<Feedback>) feedbackRepository.findAll();
    }

    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public Feedback get(Integer id) throws FeedbackNotFoundException {
        Optional<Feedback> result = feedbackRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new FeedbackNotFoundException("Could not find any feedback with ID " + id);
    }


    public void delete(Integer id) throws FeedbackNotFoundException {
        Long count = feedbackRepository.countById(id);
        if (count == null || count == 0) {
            throw new FeedbackNotFoundException("Could not find any feedback with ID " + id);
        }
        feedbackRepository.deleteById(id);
    }
}
