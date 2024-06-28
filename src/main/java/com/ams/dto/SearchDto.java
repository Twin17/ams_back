package com.ams.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {
    private String model;

    private String manufacturer;

    private Integer pageNum;

    private Integer pageSize;
}
