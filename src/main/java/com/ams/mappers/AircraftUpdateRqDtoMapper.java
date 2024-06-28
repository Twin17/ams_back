package com.ams.mappers;

import com.ams.api.update.AircraftUpdateRq;
import com.ams.dto.AircraftDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftUpdateRqDtoMapper {

    AircraftDto map(AircraftUpdateRq request);
}
