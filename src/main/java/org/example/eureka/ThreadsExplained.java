package org.example.eureka;

public class ThreadsExplained {

    static void threadClassSample() {
        //Job 1
        System.out.println("--Application started--");

        //Job 3
        MyTask myTask = new MyTask();//Child thread or the worker thread
        myTask.start();

        //Job 3
        for (int doc = 0; doc < 10; doc++) {
            System.out.println("Printing Document #" + doc);
        }

        //Job 4
        System.out.println("--Application Finished--");
    }

    static void runnableSample() {
        Runnable myRunnable = new MyTask_2();
        Thread myTaskThread = new Thread(myRunnable);
        myTaskThread.start();
    }

    //This is main thread
    public static void main(String[] args) {
        threadClassSample();
        runnableSample();
    }
    /*public static class MyTask {
        void execute() {
            for (int doc = 0; doc < 10; doc++) {
                System.out.println("@@ Printing Document #" + doc + " - Printer2");
            }
        }
    }*/

    public static class CA {

    }

    public static class MyTask extends Thread {
        @Override
        public void run() {
            for (int doc = 0; doc < 10; doc++) {
                System.out.println("@@ Printing Document #" + doc + " - Printer2");
            }
        }
    }

    public static class MyTask_2 extends CA implements Runnable {
        @Override
        public void run() {
            for (int doc = 0; doc < 10; doc++) {
                System.out.println("@@ Printing Document #" + doc + " - Printer2");
            }
        }
    }


}
