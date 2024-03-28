package com.example.demo.controller;

import com.example.demo.model.Nave;
import com.example.demo.model.Tripulante;
import com.example.demo.service.NaveService;
import com.example.demo.service.TripulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/naves")
public class NaveController {
    @Autowired
    private NaveService naveService;

    @Autowired
    private TripulanteService tripulanteService;

    @Value("${tripulante-service.url}")
    private String tripulanteServiceUrl;

    @PostMapping("/")
    public ResponseEntity<Nave> createNave(@RequestBody Nave nave) {
        // Validar que la nave tenga entre 1 y 3 tripulantes
        if (nave.getTripulantes().size() < 1 || nave.getTripulantes().size() > 3) {
            return ResponseEntity.badRequest().body(null);
        }

        // Guardar la nave
        Nave nuevaNave = naveService.createNave(nave);

        // Registrar los tripulantes en el microservicio de tripulantes
        for (Tripulante tripulante : nuevaNave.getTripulantes()) {
            tripulante.setNave(nuevaNave);
            tripulanteService.createTripulante(tripulante, tripulanteServiceUrl);
        }

        return ResponseEntity.ok().body(nuevaNave);
    }
}
