package org.leeonscoding.threadgroup;

import java.util.stream.IntStream;

public class TG1 {
    public static void main(String[] args) {

        ThreadGroup tg = new ThreadGroup("hello world group");

        Thread t1 = new Thread(tg, () -> IntStream
                .range(0,10)
                .forEach(i -> System.out.println(Thread.currentThread().getName()+" : "+i)));

        Thread t2 = new Thread(tg, () -> IntStream
                .range(0,10)
                .forEach(i -> System.out.println(Thread.currentThread().getName()+" : "+i)));

        t1.start();
        t2.start();

        System.out.println(tg.activeCount());
    }
}
