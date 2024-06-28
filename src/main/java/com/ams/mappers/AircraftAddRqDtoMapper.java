package com.ams.mappers;

import com.ams.api.add.AircraftAddRq;
import com.ams.dto.AircraftDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AircraftAddRqDtoMapper {

    @Mapping(target = "id", ignore = true)
    AircraftDto map(AircraftAddRq request);
}
