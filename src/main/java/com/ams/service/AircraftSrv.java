package com.ams.service;

import com.ams.api.add.AircraftAddRq;
import com.ams.api.add.AircraftAddRs;
import com.ams.api.get.AircraftRq;
import com.ams.api.get.AircraftRs;
import com.ams.api.update.AircraftUpdateRq;
import com.ams.api.update.AircraftUpdateRs;

public interface AircraftSrv {

    AircraftRs getAircrafts(AircraftRq request);

    AircraftAddRs addAircraft(AircraftAddRq request);

    AircraftUpdateRs updateAircraft(AircraftUpdateRq request);
}
