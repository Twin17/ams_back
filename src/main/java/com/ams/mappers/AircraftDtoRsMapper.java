package com.ams.mappers;

import com.ams.api.get.AircraftRs;
import com.ams.dto.AircraftListDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AircraftDtoRsMapper {

    @Mapping(target = "statusCode", constant = "0")
    @Mapping(target = "statusText", constant = "Ok")
    AircraftRs map(AircraftListDto aircraftListDto);
}
