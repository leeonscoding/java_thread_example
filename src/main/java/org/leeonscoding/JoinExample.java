package org.leeonscoding;

public class JoinExample {
    class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread A: "+i);
            }
        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            Thread t = new Thread(new ThreadA());
            t.setPriority(10);
            Thread.currentThread().setPriority(10);

            t.start();

            for (int i = 0; i < 10; i++) {
                if(i==7) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread B: "+i);
            }
        }
    }

    public JoinExample() {
        Thread t = new Thread(new ThreadB());
        t.start();
    }

    public static void main(String[] args) {
        new JoinExample();
    }
}
