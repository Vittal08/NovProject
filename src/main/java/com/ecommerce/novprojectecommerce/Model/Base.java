package com.ecommerce.novprojectecommerce.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass

public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// used for AutoIncrement

    private Long id;
    private Date createdAt;
    private Date updatedAt;
}