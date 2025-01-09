package com.example.batch;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskletApplication {

    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Batch Application started. 'Hello World' will print every 5 seconds.");
    }
}
