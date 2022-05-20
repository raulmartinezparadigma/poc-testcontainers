
package com.eci.poctestcontainers.ms.test.example;

import com.eci.poctestcontainers.ms.example.ExampleApplication;
import com.eci.poctestcontainers.ms.example.PaymentMethod;
import com.eci.poctestcontainers.ms.example.PaymentMethodRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
/**You are defining junit.jupiter.testinstance.lifecycle.default=per_class in your junit-platform.properties. Setting this back to per_method or just delete the line would fix your problem.

 Testcontainers JUnit extension does not really play well with this setting if you do not start to take control over the container lifecycle by yourself.

 But mixing with with the strict restriction of having a static method for the @DynamicPropertySource would require to start the container upfront the properties registration. This looks, at least to me, not ideal for a clean test structure.
 **/
@TestInstance(Lifecycle.PER_METHOD)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ExampleApplication.class)
public class ExampleApplicationTest {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Container
    public static OracleContainer container = new OracleContainer("gvenzl/oracle-xe")
                    .withReuse(true);

    // requires Spring Boot >= 2.2.6
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }


    @Test
    void contextLoads() {

        System.out.println("Context loads!");

        PaymentMethod paymentMethod= new PaymentMethod();

        paymentMethod.setId(2L);
        paymentMethod.setCode("099");
        paymentMethod.setDescription("XIAOMI");

        paymentMethodRepository.save(paymentMethod);

        List<PaymentMethod> paymentMethodList= (List<PaymentMethod>) paymentMethodRepository.findAll();
        paymentMethodList.stream().forEach(paymentMethodAux -> {
            System.out.println("Payment method:"+paymentMethodAux.getDescription());
        });

    }
}
