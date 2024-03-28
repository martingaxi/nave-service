package com.example.demo.service;

import com.example.demo.model.Nave;
import com.example.demo.repository.NaveRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NaveService {
    private final NaveRepository naveRepository;

    public List<Nave> getAllNaves() {
        return naveRepository.findAll();
    }

    public Nave createNave(Nave nave) {
        return naveRepository.save(nave);
    }

    public Nave getNaveById(Long id) {
        return naveRepository.findById(id).orElse(null);
    }

    public void deleteNave(Long id) {
        naveRepository.deleteById(id);
    }
}
