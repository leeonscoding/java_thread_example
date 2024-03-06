package org.leeonscoding.concurrent;

import java.util.concurrent.*;

public class CallbackFutureExample {
    static class Job implements Callable<Integer> {
        int num;

        public Job(int num) {
            this.num = num;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName());

            int sum=0;
            for (int i = 0; i <= num; i++) {
                sum+=i;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(10),
            new Job(2),
            new Job(3)
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for(Job job: jobs) {
            Future<Integer> f = service.submit(job);
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }
        service.shutdown();
    }
}
