package com.ams.service;

import com.ams.api.add.AircraftAddRq;
import com.ams.api.add.AircraftAddRs;
import com.ams.api.delete.AircraftDeleteRq;
import com.ams.api.delete.AircraftDeleteRs;
import com.ams.api.get.AircraftRq;
import com.ams.api.get.AircraftRs;
import com.ams.api.update.AircraftUpdateRq;
import com.ams.api.update.AircraftUpdateRs;
import com.ams.domain.Aircraft;
import com.ams.dto.AircraftDto;
import com.ams.dto.AircraftListDto;
import com.ams.dto.PageDataDto;
import com.ams.dto.SearchDto;
import com.ams.mappers.*;
import com.ams.repository.AircraftRep;
import com.ams.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AircraftSrvImpl implements AircraftSrv {

    private final AircraftRqSearchMapper searchMapper;

    private final AircraftRep aircraftRep;

    private final AircraftEntityDtoMapper entityDtoMapper;

    private final AircraftPagingDtoMapper pagingDtoMapper;

    private final AircraftDtoRsMapper dtoRsMapper;

    private final AircraftAddRqDtoMapper addRqDtoMapper;

    private final AircraftUpdateRqDtoMapper updateRqDtoMapper;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AircraftSrvImpl.class);

    @Override
    public AircraftRs getAircrafts(AircraftRq request) {
        LOGGER.info("getAircrafts: {}", JsonUtils.lazyToJsonString(request));

        final SearchDto searchDto = searchMapper.map(request);

        final PageDataDto pageDataDto = new PageDataDto();

        final List<Aircraft> aircraftList = aircraftRep.search(searchDto, pageDataDto);

        final List<AircraftDto> aircrafts = aircraftList.stream()
                .map(entityDtoMapper::map)
                .toList();

        final AircraftListDto aircraftListDto = pagingDtoMapper.map(aircrafts, pageDataDto);

        return dtoRsMapper.map(aircraftListDto);
    }

    @Override
    public AircraftAddRs addAircraft(AircraftAddRq request) {
        LOGGER.info("addAircraft: {}", JsonUtils.lazyToJsonString(request));

        final AircraftDto aircraftDto = addRqDtoMapper.map(request);

        final Long id = aircraftRep.add(aircraftDto);

        final AircraftAddRs response = new AircraftAddRs();
        response.setId(id);
        response.setStatusCode(0);
        response.setStatusText("Ok");

        return response;
    }

    @Override
    public AircraftUpdateRs updateAircraft(AircraftUpdateRq request) {
        LOGGER.info("updateAircraft: {}", JsonUtils.lazyToJsonString(request));

        final AircraftDto aircraftDto = updateRqDtoMapper.map(request);

        final Long id = aircraftRep.update(aircraftDto);

        final AircraftUpdateRs response = new AircraftUpdateRs();
        response.setId(id);
        response.setStatusCode(0);
        response.setStatusText("Ok");

        return response;
    }

    @Override
    public AircraftDeleteRs deleteAircraft(AircraftDeleteRq request) {
        LOGGER.info("deleteAircraft: {}", JsonUtils.lazyToJsonString(request));

        final AircraftDto aircraftDto = new AircraftDto();
        aircraftDto.setId(request.getId());

        aircraftRep.delete(aircraftDto);

        final AircraftDeleteRs response = new AircraftDeleteRs();
        response.setStatusCode(0);
        response.setStatusText("Ok");

        return response;
    }

}
