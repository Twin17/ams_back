package com.ams.mappers;

import com.ams.domain.Aircraft;
import com.ams.dto.AircraftDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftDtoEntityMapper {

    Aircraft map(AircraftDto aircraftDto);
}