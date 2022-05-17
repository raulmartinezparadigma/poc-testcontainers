package com.eci.poctestcontainers.ms.example.repository;

import com.eci.poctestcontainers.ms.example.entity.PaymentMethod;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentMethodRepository  extends PagingAndSortingRepository<PaymentMethod, Long> {
}
