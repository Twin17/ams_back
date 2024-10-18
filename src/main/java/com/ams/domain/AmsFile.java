package com.ams.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "amsfile")
public class AmsFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AmsFileSeq")
    @SequenceGenerator(name="AmsFileSeq", sequenceName="amsfile_seq", allocationSize=1)
    @Column(name = "id")
    private long id;

    @Column(name = "aircraft_id")
    private Long aircraftId;

    @Column(name = "name")
    private String name;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "size")
    private Long size;

    @Lob
    @Column(name = "data")
    private byte[] data;
}

