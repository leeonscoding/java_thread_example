package org.leeonscoding.concurrent;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    static class Job {
        public static void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        Thread[] t = {
                new Thread(Job::run),
                new Thread(Job::run),
                new Thread(Job::run),
                new Thread(Job::run),
                new Thread(Job::run),
                new Thread(Job::run),
                new Thread(Job::run),
                new Thread(Job::run)
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        Arrays.stream(t).forEach(service::submit);

        service.shutdown();
    }
}
