package com.pegasus.carservice;

import com.pegasus.carservice.dao.entities.Car;
import com.pegasus.carservice.dao.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarServiceApplication {
    @Autowired
    CarRepository carRepository;
    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Car car1 = Car.builder()
                    .model("Toyota Corolla")
                    .color("Red")
                    .matricule("ABC123")
                    .price(20000.0f)
                    .build();

            Car car2 = Car.builder()
                    .model("Toyota Corolla")
                    .color("Blue")
                    .matricule("XYZ456")
                    .price(22000.0f)
                    .build();

            Car car3 = Car.builder()
                    .model("Honda Civic")
                    .color("Blue")
                    .matricule("XYZ456")
                    .price(22000.0f)
                    .build();

            carRepository.save(car1);
            carRepository.save(car2);
            carRepository.save(car3);

        };
    }
}
