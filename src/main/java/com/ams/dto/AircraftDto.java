package com.ams.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AircraftDto implements Serializable {

    private Long id;

    private String model;

    private String manufacturer;

    private Integer releaseYear;

    private Integer seats;

    private String status;
}
