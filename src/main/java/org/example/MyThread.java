package org.example;

public class MyThread extends Thread {

    @Override
    public void run() {
        if (this.isDaemon())
            System.out.println("This thread is a daemon thread running!");
        else {
            System.out.println("This is not a daemon thread.");
        }
    }
}
