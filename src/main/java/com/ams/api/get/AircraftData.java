package com.ams.api.get;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftData {

    private Long id;

    private String model;

    private String manufacturer;

    private Integer releaseYear;

    private Integer seats;

    private String status;
}
