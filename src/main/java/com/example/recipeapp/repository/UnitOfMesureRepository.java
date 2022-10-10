package com.example.recipeapp.repository;

import com.example.recipeapp.domain.UnitOfMesure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMesureRepository extends CrudRepository<UnitOfMesure, Long> {
    Optional<UnitOfMesure> findByDescription(String descirpiton);
}
