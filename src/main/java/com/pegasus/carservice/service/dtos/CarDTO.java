package com.pegasus.carservice.service.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarDTO {
    private String model;
    private String color;
    private Float price;
    private String matricule;


}
