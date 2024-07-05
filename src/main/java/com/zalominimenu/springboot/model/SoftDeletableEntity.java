package com.zalominimenu.springboot.model;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class SoftDeletableEntity extends BaseEntity {

    public SoftDeletableEntity() {
        super();
    }

    protected Date deletedAt;
}