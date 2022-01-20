package com.aldeamo.prueba.model.repository;

import com.aldeamo.prueba.model.entity.Arrays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArraysRepository extends JpaRepository<Arrays, Integer> {
    @Query("SELECT a.inputArray FROM Arrays a WHERE a.id=:id")
    Optional<String> findArrayById(@Param("id") int id);
}