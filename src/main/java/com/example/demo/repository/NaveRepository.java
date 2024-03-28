package com.example.demo.repository;

import com.example.demo.model.Nave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaveRepository extends JpaRepository<Nave, Long> {
}
