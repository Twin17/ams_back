package com.ams.service;

import com.ams.api.get.AmsFileInfo;
import com.ams.api.get.AmsFilesInfoRq;
import com.ams.api.get.AmsFilesInfoRs;
import com.ams.domain.AmsFile;
import com.ams.mappers.AmsFilesInfoMapper;
import com.ams.repository.AmsFileJpaRep;
import com.ams.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AmsFileSrvImpl implements AmsFileSrv {

    private final AmsFileJpaRep amsFileJpaRep;

    private final AmsFilesInfoMapper amsFilesInfoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(AmsFileSrvImpl.class);

    @Override
    @Transactional(readOnly = true)
    public AmsFilesInfoRs getAmsFilesInfo(AmsFilesInfoRq rq) {
        LOGGER.info("getAmsFilesInfo: {}", JsonUtils.lazyToJsonString(rq));

        final Long aircraftId = rq.getAircraftId();

        final List<AmsFile> amsFiles = amsFileJpaRep.findAmsFilesByAircraftId(aircraftId);

        final List<AmsFileInfo> amsFileInfoList = amsFilesInfoMapper.map(amsFiles);

        final AmsFilesInfoRs amsFilesInfoRs = new AmsFilesInfoRs();
        amsFilesInfoRs.setAmsFileInfoList(amsFileInfoList);

        return amsFilesInfoRs;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<byte[]> getAmsFile(Long id) {
        LOGGER.info("getAmsFile: {}", JsonUtils.lazyToJsonString(id));

        Optional<AmsFile> fileEntityOptional = amsFileJpaRep.findById(id);

        if (fileEntityOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        AmsFile amsFile = fileEntityOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + amsFile.getName() + "\"")
                .contentType(MediaType.valueOf(amsFile.getContentType()))
                .body(amsFile.getData());
    }

    @Override
    @Transactional
    public ResponseEntity<String> save(MultipartFile file, Long aircraftId) {
        LOGGER.info("file save call");

        try {
            final String fileName = Objects.requireNonNull(file.getOriginalFilename());
            LOGGER.info("file save name: {}, aircraftId: {}", fileName, aircraftId);

            AmsFile amsFile = new AmsFile();
            amsFile.setAircraftId(aircraftId);
            amsFile.setName(StringUtils.cleanPath(fileName));
            amsFile.setContentType(file.getContentType());
            amsFile.setData(file.getBytes());
            amsFile.setSize(file.getSize());
            amsFileJpaRep.save(amsFile);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            LOGGER.error("Error file saving: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }
}
