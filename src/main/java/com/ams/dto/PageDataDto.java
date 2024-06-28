package com.ams.dto;

import lombok.Data;

@Data
public class PageDataDto {

    private Integer pegeNum;

    private Integer elements;

    private Integer total;

    private Integer pages;

    private Integer maxPageSize;
}
