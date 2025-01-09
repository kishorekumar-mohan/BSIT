package com.example.chunks;

import org.springframework.batch.item.ItemProcessor;

public class EmployeeProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) throws Exception {
       //System.out.println(item.toUpperCase());
        return item.toUpperCase(); 
    }
}
