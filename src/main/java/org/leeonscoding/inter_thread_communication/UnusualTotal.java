package org.leeonscoding.inter_thread_communication;

public class UnusualTotal {

    /*
    * The output is between 0 and 5050
    * because the main can start first or the child can start first
    *
    * */

    class SumInThread extends Thread {
        int total = 0;

        @Override
        public void run() {
            for(int i=0; i<=100; i++) {
                total = total+i;

            }
            System.out.println("child: "+total);
        }
    }

    public UnusualTotal() {
        SumInThread t = new SumInThread();
        t.start();

        System.out.println("main: " + t.total);
    }

    public static void main(String[] args) {
        new UnusualTotal();
    }
}
