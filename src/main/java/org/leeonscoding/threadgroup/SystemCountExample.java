package org.leeonscoding.threadgroup;

import java.util.Arrays;

public class SystemCountExample {
    public static void main(String[] args) {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        System.out.println(system.activeCount());

        Thread[] t = new Thread[system.activeCount()];
        system.enumerate(t);

        Arrays.stream(t).forEach(thread -> System.out.println(thread.getName()));
    }
}
