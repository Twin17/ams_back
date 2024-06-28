package com.ams.api.get;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AircraftRs implements Serializable {

    private List<AircraftData> aircrafts;

    private AircraftPageData pageData;

    private Integer statusCode;

    private String statusText;
}
