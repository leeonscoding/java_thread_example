package org.leeonscoding.sync;

public class Sync2 {
    /*
    * This code will return irregular output
    * because Threads are operating on different objects
    *
    * */
    class Display {
        public synchronized void wish(String name) {
            for(int i=0; i<10000; i++) {
                /*try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }*/
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

    public Sync2() {
        Display d1 = new Display();
        Display d2 = new Display();

        MyThread t1 = new MyThread(d1, "siam");
        MyThread t2 = new MyThread(d2, "mimi");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new Sync2();
    }
}
