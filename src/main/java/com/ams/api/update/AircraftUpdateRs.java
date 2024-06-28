package com.ams.api.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftUpdateRs {

    private Long id;

    private Integer statusCode;

    private String statusText;
}
