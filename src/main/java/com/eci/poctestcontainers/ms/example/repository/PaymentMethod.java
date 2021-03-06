package com.eci.poctestcontainers.ms.example.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
