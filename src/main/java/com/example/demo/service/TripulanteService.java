package com.example.demo.service;

import com.example.demo.model.Tripulante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TripulanteService {
    @Autowired
    private RestTemplate restTemplate;

    public Tripulante createTripulante(Tripulante tripulante, String tripulanteServiceUrl) {
        ResponseEntity<Tripulante> responseEntity = restTemplate.postForEntity(tripulanteServiceUrl, tripulante, Tripulante.class);
        return responseEntity.getBody();
    }
}
