package com.ams.api.add;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftAddRq {

    private String model;

    private String manufacturer;

    private Integer releaseYear;

    private Integer seats;

    private String status;
}
