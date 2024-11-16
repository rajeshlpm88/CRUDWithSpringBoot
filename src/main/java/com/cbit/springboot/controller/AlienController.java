package com.cbit.springboot.controller;



import com.cbit.springboot.model.Alien;
import com.cbit.springboot.service.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aliens")
@CrossOrigin(origins = "*")
public class AlienController {

    @Autowired
    private AlienService service;

    @GetMapping
    public List<Alien> getAllAliens() {
        return service.getAllAliens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alien> getAlienById(@PathVariable String id) {
        Optional<Alien> alien = service.getAlienById(id);
        if (alien.isPresent()) {
            return ResponseEntity.ok(alien.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Alien createAlien(@RequestBody Alien alien) {
        return service.saveAlien(alien);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Alien> updateAlien(@PathVariable String id, @RequestBody Alien alienDetails) {
        Alien updatedAlien = service.updateAlien(id, alienDetails.isSub());
        if (updatedAlien != null) {
            return ResponseEntity.ok(updatedAlien);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
