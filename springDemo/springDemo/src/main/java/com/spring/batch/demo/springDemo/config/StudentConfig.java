package com.spring.batch.demo.springDemo.config;
import com.spring.batch.demo.springDemo.processor.StudentProcessor;
import com.spring.batch.demo.springDemo.reader.StudentReader;
import com.spring.batch.demo.springDemo.writer.StudentWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StudentConfig {

    @Autowired
    private StudentReader studentReader;

    @Autowired
    private StudentWriter studentWriter;

    @Autowired
    private StudentProcessor studentProcessor;



    @Bean
    public Job sampleJob(JobRepository jobRepository,Step firstStep)
    {
        return new JobBuilder("sampleJob", jobRepository).flow(firstStep).end().build();
    }

    @Bean
    public Step firstStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        System.out.println("First step");
        return new StepBuilder("first step",jobRepository).<Integer,Long>chunk(3,transactionManager).reader(studentReader).processor(studentProcessor).writer(studentWriter).build();
    }


}
