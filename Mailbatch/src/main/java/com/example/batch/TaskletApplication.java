package com.example.batch;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskletApplication {

    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Generating.....");
    }
}
