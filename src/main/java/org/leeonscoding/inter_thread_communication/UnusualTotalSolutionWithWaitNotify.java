package org.leeonscoding.inter_thread_communication;

public class UnusualTotalSolutionWithWaitNotify {

    /*
    * 2 sync blocks
    * Without sync blocks, we will get 2 errors
    * one for wait
    * one for notify
    *
    * */

    class SumInThread extends Thread {
        int total = 0;

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("child thread starts calculation");
                for (int i = 0; i <= 100; i++) {
                    total = total + i;

                }
                System.out.println("child send notification");
                this.notify();
            }
            System.out.println("child: "+total);
        }
    }

    public UnusualTotalSolutionWithWaitNotify() {
        SumInThread t = new SumInThread();
        t.start();

        synchronized (t) {
            try {
                System.out.println("main thread paused for child. calling wait");
                t.wait();
                System.out.println("main thread gets notification");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("main: " + t.total);
    }

    public static void main(String[] args) {
        new UnusualTotalSolutionWithWaitNotify();
    }
}
