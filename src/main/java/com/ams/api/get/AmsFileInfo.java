package com.ams.api.get;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmsFileInfo {

    private Long id;

    private Long aircraftId;

    private String name;

    private Long size;

    private String url;

    private String contentType;
}
