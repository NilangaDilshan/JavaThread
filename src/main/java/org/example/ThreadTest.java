package org.example;

public class ThreadTest {
    public static void main(String[] args) {

        /*System.out.println(Thread.activeCount());
        Thread.currentThread().setName("Slayer");
        System.out.println(Thread.currentThread().getName());

        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());

        System.out.println(Thread.currentThread().isAlive());

        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("You are done");*/

        /*Thread.currentThread().setPriority(10);
        MyThread myThread1 = new MyThread();
        myThread1.start();
        System.out.println(myThread1.isAlive());
        myThread1.setName("My First Thread");
        System.out.println(myThread1.getName());
        System.out.println(myThread1.getPriority());

        System.out.println(Thread.activeCount());

        myThread1.setDaemon(true);*/

        MyThread myThread = new MyThread();
        /*myThread.setDaemon(true);
        System.out.println(myThread.isDaemon());*/
        myThread.start();

        System.out.println("Thread count: " + Thread.activeCount());
    }
}
