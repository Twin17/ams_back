package com.ams.controller;

import com.ams.api.add.AircraftAddRq;
import com.ams.api.add.AircraftAddRs;
import com.ams.api.delete.AircraftDeleteRq;
import com.ams.api.delete.AircraftDeleteRs;
import com.ams.api.get.AircraftRq;
import com.ams.api.get.AircraftRs;
import com.ams.api.update.AircraftUpdateRq;
import com.ams.api.update.AircraftUpdateRs;
import com.ams.service.AircraftSrv;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class AircraftController {

    private final AircraftSrv aircraftSrv;

    @PostMapping(value = "/getAircrafts")
    public AircraftRs getAircrafts(@RequestBody AircraftRq request) {
        return aircraftSrv.getAircrafts(request);
    }

    @PostMapping(value = "/addAircraft")
    public AircraftAddRs addAircraft(@RequestBody AircraftAddRq request) {
        return aircraftSrv.addAircraft(request);
    }

    @PostMapping(value = "/updateAircraft")
    public AircraftUpdateRs updateAircraft(@RequestBody AircraftUpdateRq request) {
        return aircraftSrv.updateAircraft(request);
    }

    @PostMapping(value = "/deleteAircraft")
    public AircraftDeleteRs deleteAircraft(@RequestBody AircraftDeleteRq request) {
        return aircraftSrv.deleteAircraft(request);
    }
}
