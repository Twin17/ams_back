package com.ams.mappers;

import com.ams.dto.AircraftDto;
import com.ams.dto.AircraftListDto;
import com.ams.dto.PageDataDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AircraftPagingDtoMapper {

    AircraftListDto map(List<AircraftDto> aircrafts, PageDataDto pageData);
}
