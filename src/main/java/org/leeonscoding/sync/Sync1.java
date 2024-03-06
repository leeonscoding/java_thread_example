package org.leeonscoding.sync;

public class Sync1 {
    /*
    * This code will return regular output
    * because Threads are operating on same objects
    * But if the method has 1lac line of code, whole block will be slow
    * */
    class Display {
        public synchronized void wish(String name) {
            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(name + " : "+i);
            }
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

    public Sync1() {
        Display display = new Display();
        MyThread t1 = new MyThread(display, "siam");
        MyThread t2 = new MyThread(display, "mimi");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new Sync1();
    }
}
