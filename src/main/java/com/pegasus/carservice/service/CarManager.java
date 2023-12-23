package com.pegasus.carservice.service;

import com.pegasus.carservice.service.dtos.CarDTO;

import java.util.List;

public interface CarManager {
    public List<CarDTO> getCarByModel(String model);
    public List<CarDTO> getCarByModelAndPrice(String model,Float price);

    public CarDTO saveCar(CarDTO carDto);
    public void deleteCar(Long id);

}
