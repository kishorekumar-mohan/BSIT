package com.example.batch;

//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.stereotype.Component;
//
//import java.util.Scanner;
//
//@Component
//public class HelloWorldTasklet implements Tasklet {
//
//    private volatile boolean stopExecution = false;
//
//    @Override
//    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Type 'stop' to terminate the execution.");
//        while (!stopExecution) {
//            System.out.println("Hello World");
//            Thread.sleep(1000);
//
//            if (scanner.hasNextLine()) {
//                String input = scanner.nextLine();
//                if ("stop".equalsIgnoreCase(input.trim())) {
//                    stopExecution = true;
//                }
//            }
//        }
//
//        System.out.println("Execution stopped by user.");
//        return RepeatStatus.FINISHED;
//    }
//}





import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        System.out.println("Hello world");
        return RepeatStatus.FINISHED;
    }
}


