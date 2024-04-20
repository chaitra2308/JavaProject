package com.example.javaproject.Transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    public List<Transport> listAll() {
        return (List<Transport>) transportRepository.findAll();
    }

    public void save(Transport transport) {
        transportRepository.save(transport);
    }

    public Transport get(Integer id) throws TransportNotFoundException {
        Optional<Transport> result = transportRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new TransportNotFoundException("Could not find any transport with ID " + id);
    }

    public void delete(Integer id) throws TransportNotFoundException {
        if (!transportRepository.existsById(id)) {
            throw new TransportNotFoundException("Could not find any transport with ID " + id);
        }
        transportRepository.deleteById(id);
    }
}
