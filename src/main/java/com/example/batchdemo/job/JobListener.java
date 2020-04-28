package com.example.batchdemo.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobListener extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        super.beforeJob(jobExecution);
        System.out.println("Start JOB");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        super.afterJob(jobExecution);
        System.out.println("End JOB");
    }

}
