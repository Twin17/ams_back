package com.ams.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public abstract class IdentifiableEntity implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
}
