package com.spring.batch.demo.springDemo.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.TransactionAwareProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StudentWriter implements ItemWriter<Long> {
    List<Long> output = TransactionAwareProxyFactory.createTransactionalList();

    @Override
    public void write(Chunk<? extends Long> Chunk) throws Exception {
        System.out.println("Inside writer");
        System.out.println(Chunk.getItems());

    }
}
