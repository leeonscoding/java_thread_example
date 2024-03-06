package org.leeonscoding;

public class ExtendThreadClass {

    class Thread1 extends Thread {

        //No new thread will be created
    /*@Override
    public void start() {
        //super.start();
        System.out.println("override");
    }*/

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread: "+i);
            }
        }
    }

    public ExtendThreadClass() {
        Thread t = new Thread1();
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main thread: "+i);
        }
    }

    public static void main(String[] args) {
        new ExtendThreadClass();
    }
}
