package com.example.javaproject.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> listAll() {
        return (List<Destination>) destinationRepository.findAll();
    }

    public Destination getById(Integer id) throws DestinationNotFoundException {
        Optional<Destination> result = destinationRepository.findById(id);
        if (result.isPresent()) {
            Destination destination = result.get();
            return new Destination.Builder()
                    .withId(destination.getId())
                    .withDestName(destination.getDestName())
                    .withPicture(destination.getPicture())
                    .withText(destination.getText())
                    .build();
        }
        throw new DestinationNotFoundException("Could not find any destination with ID " + id);
    }
}
