package com.spring.batch.demo.springDemo.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StudentProcessor implements ItemProcessor<Integer,Long> {

    @Bean
    public Long process(Integer item) throws Exception {
        System.out.println("Inside Processor...");
        return Long.valueOf(item);
    }
}
