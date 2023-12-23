package com.pegasus.carservice.dao.repositories;

import com.pegasus.carservice.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByModel(String model);
    List<Car> findByModelAndPrice(String model,Float price);

    Optional<Car> findCarByMatricule(String matricule);

}
