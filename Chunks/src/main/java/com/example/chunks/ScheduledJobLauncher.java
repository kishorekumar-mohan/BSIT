package com.example.chunks;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Date;

@Component
public class ScheduledJobLauncher {

    private JobLauncher jobLauncher;
    private Job job;
    //private boolean isJobPrinted = false;  

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void runJob() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addDate("timestamp", new Date())
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(job, params);
            System.out.println("Job Status: " + execution.getStatus());
           
//            if (!isJobPrinted) {
//                System.out.println("Job Status: " + execution.getStatus());
//                isJobPrinted = true;
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
