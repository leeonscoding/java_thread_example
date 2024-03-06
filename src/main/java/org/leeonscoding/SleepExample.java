package org.leeonscoding;

public class SleepExample {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println("Main thread: "+i);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 101; i < 200; i++) {
            System.out.println("Main thread: "+i);
        }
    }
}
