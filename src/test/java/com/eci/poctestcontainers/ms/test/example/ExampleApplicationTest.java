package com.eci.poctestcontainers.ms.test.example;

import com.eci.poctestcontainers.ms.example.ExampleApplication;
import com.eci.poctestcontainers.ms.example.entity.PaymentMethod;
import com.eci.poctestcontainers.ms.example.repository.PaymentMethodRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest (classes = ExampleApplication.class)
public class ExampleApplicationTest {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Container
    public static OracleContainer container = new OracleContainer("gvenzl/oracle-xe").withReuse(true);




    @Test
    void contextLoads() {

        System.out.println("Context loads!");

        PaymentMethod paymentMethod= new PaymentMethod();

        paymentMethod.setId(1L);
        paymentMethod.setCode("001");
        paymentMethod.setDescription("ECI_CARD");

        paymentMethodRepository.save(paymentMethod);

        List<PaymentMethod> paymentMethodList= (List<PaymentMethod>) paymentMethodRepository.findAll();
        paymentMethodList.stream().forEach(paymentMethodAux -> {
            System.out.println("Payment method:"+paymentMethodAux.getDescription());
        });

    }
}
