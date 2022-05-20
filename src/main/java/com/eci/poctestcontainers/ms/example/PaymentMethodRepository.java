package com.eci.poctestcontainers.ms.example;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentMethodRepository  extends PagingAndSortingRepository<PaymentMethod, Long> {
}
