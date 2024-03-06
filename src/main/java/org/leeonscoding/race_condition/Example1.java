package org.leeonscoding.race_condition;

public class Example1 {
    static class Counter {
        int count=10;

        public void add(int value) {
            count = count + value;
            System.out.println("ops: "+count);
        }

        public void sub(int value) {
            count = count - value;
            System.out.println("ops: "+count);
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> counter.add(5));
        Thread t2 = new Thread(() -> counter.sub(5));
        Thread t3 = new Thread(() -> counter.add(5));

        t1.start();
        System.out.println(counter.count);

        t2.start();
        System.out.println(counter.count);

        t3.start();
        System.out.println(counter.count);
    }
}
