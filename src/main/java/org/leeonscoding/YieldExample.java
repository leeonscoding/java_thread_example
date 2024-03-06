package org.leeonscoding;

public class YieldExample {
    class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread A: "+i);
            }
        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            Thread t = new Thread(new ThreadA());
            t.setPriority(10);
            Thread.currentThread().setPriority(10);

            t.start();

            for (int i = 0; i < 10; i++) {
                if(i==7) {
                    Thread.yield();
                }
                System.out.println("Thread B: "+i);
            }
        }
    }

    public YieldExample() {
        Thread t = new Thread(new ThreadB());
        t.start();
    }

    public static void main(String[] args) {
        new YieldExample();
    }
}
