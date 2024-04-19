package com.example.javaproject.Accommodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    public List<Accommodation> listAll() {
        return (List<Accommodation>) accommodationRepository.findAll();
    }

    public void save(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }

    public Accommodation get(Integer id) throws AccommodationNotFoundException {
        Optional<Accommodation> result = accommodationRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new AccommodationNotFoundException("Could not find any accommodation with ID " + id);
    }

    public void delete(Integer id) throws AccommodationNotFoundException {
        Long count = accommodationRepository.countById(id);
        if (count == null || count == 0) {
            throw new AccommodationNotFoundException("Could not find any accommodation with ID " + id);
        }
        accommodationRepository.deleteById(id);
    }
}
