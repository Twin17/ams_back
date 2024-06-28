package com.ams.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "aircraft")
@Getter
@Setter
public class Aircraft implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AircraftSeq")
    @SequenceGenerator(name="AircraftSeq", sequenceName="aircraft_seq", allocationSize=1)
    @Column(name = "id")
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "releaseyear")
    private Integer releaseYear;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "status")
    private String status;
}
