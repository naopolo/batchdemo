package com.example.batchdemo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class Tasklet01Config {
    @Autowired
    private Tasklet01 tasklet01;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step01() {
        return stepBuilderFactory.get("step01").tasklet(tasklet01).build();
    }

    @Bean
    public Job job(Step step1, Step step2) throws Exception {
    	return jobBuilderFactory.get("job")
    			.incrementer(new RunIdIncrementer())
    			.listener(listener())
    			.start(step01()).build();
    	}
    
    @Bean
    public JobExecutionListener listener(){
        return new JobListener();
     }
}
