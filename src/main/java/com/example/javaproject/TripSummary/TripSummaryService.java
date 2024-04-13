package com.example.javaproject.TripSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripSummaryService {

    @Autowired
    private TripSummaryRepository tripSummaryRepository;

    public List<TripSummary> listAll() {
        return (List<TripSummary>) tripSummaryRepository.findAll();
    }

    public void save(TripSummary tripSummary) {
        tripSummaryRepository.save(tripSummary);
    }

    public TripSummary get(Integer id) throws TripSummaryNotFoundException {
        Optional<TripSummary> result = tripSummaryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new TripSummaryNotFoundException("Could not find any trip summary with ID " + id);
    }

    public void delete(Integer id) throws TripSummaryNotFoundException {
        Long count = tripSummaryRepository.countById(id);
        if (count == null || count == 0) {
            throw new TripSummaryNotFoundException("Could not find any trip summary with ID " + id);
        }
        tripSummaryRepository.deleteById(id);
    }
}
