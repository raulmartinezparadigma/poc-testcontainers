package com.eci.poctestcontainers.ms.test.example;

import com.eci.poctestcontainers.ms.example.ExampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (classes = ExampleApplication.class)
public class ExampleApplicationTest {

    @Test
    void contextLoads() {

        System.out.println("Context loads!");
    }
}
