package org.leeonscoding.deadlock;

public class DeadlockPreventionExample1 {
    static class Resource {

        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void method1(Resource r) {
            synchronized(lock1) {
                System.out.println(Thread.currentThread().getName()+" is executing method 1");

                try {
                    Thread.sleep(6000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName()+" is trying to execute another thread's method2");
                synchronized (r.lock2) {
                    r.method2(this);
                }

            }

        }

        public synchronized void method2(Resource r) {
            synchronized(lock2) {
                System.out.println(Thread.currentThread().getName()+" is executing method 1");

                try {
                    Thread.sleep(6000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName()+" is trying to execute another thread's method2");
                synchronized (r.lock1) {
                    r.method1(this);
                }
            }

        }
    }

    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        Thread t1 = new Thread(() -> r1.method1(r2));
        Thread t2 = new Thread(() -> r2.method1(r1));

        t1.start();
        t2.start();
    }
}
