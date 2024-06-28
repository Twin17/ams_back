package com.ams.api.get;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AircraftRq implements Serializable {
    private String model;

    private String manufacturer;

    private Integer pageNum;

    private Integer pageSize;
}
