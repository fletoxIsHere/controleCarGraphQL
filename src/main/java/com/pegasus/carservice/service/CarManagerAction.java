package com.pegasus.carservice.service;

import com.pegasus.carservice.dao.entities.Car;
import com.pegasus.carservice.dao.repositories.CarRepository;
import com.pegasus.carservice.service.dtos.CarDTO;
import com.pegasus.carservice.service.mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CarManagerAction implements CarManager {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;


    @Override
    public List<CarDTO> getCarByModel(String model) {

        List<Car> cars = carRepository.findByModel(model);

        List<CarDTO> carDTOs = cars.stream()
                .map(m->carMapper.fromCarToCarDto(m))
                .collect(Collectors.toList());

        return carDTOs;
    }


    @Override
    public List<CarDTO> getCarByModelAndPrice(String model, Float price) {
        List<Car> cars = carRepository.findByModelAndPrice(model,price);

        List<CarDTO> carDTOs = cars.stream()
                .map(m->carMapper.fromCarToCarDto(m))
                .collect(Collectors.toList());

        return carDTOs;
    }

    @Override
    public CarDTO saveCar(CarDTO carDto) {
//        Optional<Car> existingCar = carRepository.findCarByMatricule(carDto.getMatricule());
//        if (existingCar.isPresent()) {
//            throw new IllegalStateException("A car with matricule " + carDto.getMatricule() + " already exists.");
//        }

        return carMapper.fromCarToCarDto(carRepository.save(carMapper.fromCarDtoToCar(carDto)));
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Car> existingCar = carRepository.findById(id);
        if (!existingCar.isPresent()) {
            throw new IllegalStateException("not found");
        }
        carRepository.deleteById(id);

    }
}
