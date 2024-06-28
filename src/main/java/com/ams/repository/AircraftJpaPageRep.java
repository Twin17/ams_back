package com.ams.repository;

import com.ams.domain.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftJpaPageRep extends JpaRepository<Aircraft, Long>, JpaSpecificationExecutor<Aircraft> {
}
