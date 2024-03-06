package org.leeonscoding.deadlock;

public class DeadlockExample {
    static class Resource {
        public synchronized void method1(Resource r) {
            System.out.println(Thread.currentThread().getName()+" is executing method 1");

            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName()+" is trying to execute another thread's method2");
            r.method2(this);
        }

        public synchronized void method2(Resource r) {
            System.out.println(Thread.currentThread().getName()+" is executing method 1");

            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName()+" is trying to execute another thread's method1");
            r.method1(this);
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
