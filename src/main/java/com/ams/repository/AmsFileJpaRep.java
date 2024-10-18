package com.ams.repository;

import com.ams.domain.AmsFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmsFileJpaRep extends JpaRepository<AmsFile, Long> {

    List<AmsFile> findAmsFilesByAircraftId(Long aircraftId);

}
