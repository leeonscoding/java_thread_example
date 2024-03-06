package org.leeonscoding.sync;

public class SyncBlock2 {
    /*
    * Example of class level lock
    * The objects of the Display class has only 1 lock
    * Only 1 object can access this lock at a time
    * */
    class Display {
        public void wish(String name) {

            //1 lac line code
            synchronized (Display.class) {
                for(int i=0; i<10000; i++) {
                    /*try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }*/
                    System.out.println(name + " : "+i);
                }
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
