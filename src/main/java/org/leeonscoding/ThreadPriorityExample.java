package org.leeonscoding;

public class ThreadPriorityExample {

    class Thread1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread: "+i);
            }
        }
    }

    public ThreadPriorityExample() {
        /*
         * Priority must be int
         * Range 1 to 10
         * Min=1, max=10
         * default=5
         * */
        Thread.currentThread().setPriority(2);

        Thread t = new Thread(new Thread1());
        t.setPriority(10);
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main thread: "+i);
        }
    }

    public static void main(String[] args) {
        new ThreadPriorityExample();
    }
}
