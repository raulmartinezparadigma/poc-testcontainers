package com.eci.poctestcontainers.ms.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentMethodRepository  extends PagingAndSortingRepository<PaymentMethod, Long> {
}
