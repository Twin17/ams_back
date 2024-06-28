package com.ams.api.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftUpdateRq {

    private Long id;

    private String model;

    private String manufacturer;

    private Integer releaseYear;

    private Integer seats;

    private String status;
}
