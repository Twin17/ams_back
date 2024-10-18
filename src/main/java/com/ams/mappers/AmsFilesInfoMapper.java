package com.ams.mappers;

import com.ams.api.get.AmsFileInfo;
import com.ams.domain.AmsFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AmsFilesInfoMapper {

    List<AmsFileInfo> map(List<AmsFile> amsFiles);
}
