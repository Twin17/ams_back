package com.ams.api.get;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftPageData {
    private Integer pegeNum;

    private Integer elements;

    private Integer total;

    private Integer pages;

    private Integer maxPageSize;
}
