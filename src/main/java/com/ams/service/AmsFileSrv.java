package com.ams.service;

import com.ams.api.get.AmsFilesInfoRq;
import com.ams.api.get.AmsFilesInfoRs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AmsFileSrv {

    AmsFilesInfoRs getAmsFilesInfo(AmsFilesInfoRq rq);

    ResponseEntity<byte[]> getAmsFile(Long id);

    ResponseEntity<String> save(MultipartFile file, Long aircraftId);
}
