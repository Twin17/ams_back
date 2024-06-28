package com.ams.repository;

import com.ams.domain.Aircraft;
import com.ams.dto.AircraftDto;
import com.ams.dto.PageDataDto;
import com.ams.dto.SearchDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRep {

    List<Aircraft> search(SearchDto request, PageDataDto pageData);

    Long add(AircraftDto aircraftDto);

    Long update(AircraftDto aircraftDto);
}
