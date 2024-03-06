package org.leeonscoding;

public class ImplementRunnableExample {

    class Thread1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread: "+i);
            }
        }
    }

    public ImplementRunnableExample() {
        Thread t = new Thread(new Thread1());
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main thread: "+i);
        }
    }

    public static void main(String[] args) {
        new ImplementRunnableExample();
    }
}
