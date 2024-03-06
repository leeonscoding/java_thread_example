package org.leeonscoding.inter_thread_communication;

public class UnusualTotalSolutionWithSleep {

    /*
    * Not recommended
    * because the program may need 1 nano sec
    * But the sleep paused for 2 sec
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

    public UnusualTotalSolutionWithSleep() {
        SumInThread t = new SumInThread();
        t.start();

        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("main: " + t.total);
    }

    public static void main(String[] args) {
        new UnusualTotalSolutionWithSleep();
    }
}
