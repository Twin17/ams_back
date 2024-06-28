package com.ams.repository;

import com.ams.domain.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftJpaRep extends JpaRepository<Aircraft, Long> {

}
