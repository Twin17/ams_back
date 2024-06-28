package com.ams.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AircraftListDto {

    private List<AircraftDto> aircrafts;

    private PageDataDto pageData;
}
