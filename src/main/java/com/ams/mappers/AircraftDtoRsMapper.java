package com.ams.mappers;

import com.ams.api.get.AircraftRs;
import com.ams.dto.AircraftListDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AircraftDtoRsMapper {

    @Mapping(target = "statusCode", ignore = true)
    @Mapping(target = "statusText", ignore = true)
    AircraftRs map(AircraftListDto aircraftListDto);
}
