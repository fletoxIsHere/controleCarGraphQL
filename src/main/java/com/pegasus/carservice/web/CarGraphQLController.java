package com.pegasus.carservice.web;

import com.pegasus.carservice.service.CarManager;
import com.pegasus.carservice.service.dtos.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarGraphQLController {
    @Autowired
    private CarManager carManager;
    // getCarById(id: Float) : CarDto

    @QueryMapping
    public List<CarDTO> getCarByModel(@Argument String model) {
        return carManager.getCarByModel(model);
    }

    @QueryMapping
    public List<CarDTO> getCarByModelAndPrice(@Argument String model,@Argument Float price) {
        return carManager.getCarByModelAndPrice(model,price);
    }

    @MutationMapping
    public CarDTO saveCar(CarDTO carDto) {
        return carManager.saveCar(carDto);
    }

    @QueryMapping
    public void deleteCar(@Argument Long id) {
        carManager.deleteCar(id);
    }
}
