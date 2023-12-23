package com.pegasus.carservice.service.mappers;

import com.pegasus.carservice.dao.entities.Car;
import com.pegasus.carservice.service.dtos.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public CarDTO fromCarToCarDto(Car car) {
        return this.modelMapper.map(car, CarDTO.class);
    }

    public Car fromCarDtoToCar(CarDTO carDto) {
        return this.modelMapper.map(carDto, Car.class);
    }


}
