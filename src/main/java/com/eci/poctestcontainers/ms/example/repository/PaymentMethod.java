package com.eci.poctestcontainers.ms.example.repository;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "PAYMENTMETHOD")
@Getter
@Setter
public class PaymentMethod {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE", unique = true, nullable = false, length = 3)
    private String code;

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;


}
