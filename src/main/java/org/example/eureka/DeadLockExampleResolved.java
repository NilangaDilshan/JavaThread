package org.example.eureka;

public class DeadLockExampleResolved {
    
    public static void main(String[] args) {
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            // Acquire resource1 before resource2
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Release resource1 before acquiring resource2
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
                System.out.println("Thread 1: Released resource 2");
            }
            System.out.println("Thread 1: Released resource 1");
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            // Acquire resource1 before resource2
            synchronized (resource1) {
                System.out.println("Thread 2: Locked resource 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Release resource1 before acquiring resource2
                synchronized (resource2) {
                    System.out.println("Thread 2: Locked resource 2");
                }
                System.out.println("Thread 2: Released resource 2");
            }
            System.out.println("Thread 2: Released resource 1");
        });

        thread1.start();
        thread2.start();
    }
}
