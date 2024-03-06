package org.leeonscoding.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncBlock2 {
    /*
    * Remove synchronized from the previous example
    * and apply lock
    *
    * */
    class Display {
        Lock lock = new ReentrantLock();

        public void wish(String name) {

            //1 lac line code
            try {
                if(lock.tryLock(5, TimeUnit.SECONDS)) {
                    lock.lock();
                    for(int i=0; i<10000; i++) {
                    /*try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }*/
                        System.out.println(name + " : "+i);
                    }
                    lock.unlock();
                } else {
                    System.out.println("try failed");
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            //another 1 lac line code
        }
    }

    class MyThread extends Thread {
        Display d;
        String name;

        public MyThread(Display d, String name) {
            this.d = d;
            this.name = name;
        }

        @Override
        public void run() {
            d.wish(name);
        }
    }

    public SyncBlock2() {
        Display d1 = new Display();
        Display d2 = new Display();

        MyThread t1 = new MyThread(d1, "siam");
        MyThread t2 = new MyThread(d2, "mimi");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new SyncBlock2();
    }
}
