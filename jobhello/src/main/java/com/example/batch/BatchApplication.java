package com.example.batch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:batchConfiguration.xml")  
public class BatchApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BatchApplication.class);
        System.out.println("Batch Application started. 'Hello World' will print every 5 seconds.");
    }
}
