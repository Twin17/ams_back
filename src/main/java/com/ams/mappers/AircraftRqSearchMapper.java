package com.ams.mappers;

import com.ams.api.get.AircraftRq;
import com.ams.dto.SearchDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftRqSearchMapper {

    SearchDto map(AircraftRq request);
}
