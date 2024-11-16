package com.cbit.springboot.service;

import com.cbit.springboot.model.Alien;
import com.cbit.springboot.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlienService {

    @Autowired
    private AlienRepository repository;

    public List<Alien> getAllAliens() {
        return repository.findAll();
    }

    public Optional<Alien> getAlienById(String id) {
        return repository.findById(id);
    }

    public Alien saveAlien(Alien alien) {
        return repository.save(alien);
    }

    public Alien updateAlien(String id, boolean sub) {
        Optional<Alien> optionalAlien = repository.findById(id);
        if (optionalAlien.isPresent()) {
            Alien alien = optionalAlien.get();
            alien.setSub(sub);
            return repository.save(alien);
        }
        return null;
    }
}

