package org.example.eureka;


public class SyncThreadApp {
    public static void main(String[] args) {
        System.out.println("--Application Started--");
        Printer printer = new Printer();
        //printer.printDocuments(10, "Dila Doc");
        MyThread myThread = new MyThread(printer);
        YourThread yourThread = new YourThread(printer);
        myThread.start();
        //This can not be done in multiple threads.
        //So we use synchronized methods to avoid jumbling across the threads
        /*try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        yourThread.start();
        System.out.println("--Application Failed--");
    }

    public static class Printer {
        //We can  mark the method synchronized to make it synchronized.
        //Meantime we can mark the runnable method synchronized as well
        //Example is mentioned below two classes
        void printDocuments(int numberOfCopies, String docname) {
            for (int i = 0; i < numberOfCopies; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(">> Printing Document " + docname + " " + i);
            }
        }
    }

    static class MyThread extends Thread {
        Printer printer;

        MyThread(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            synchronized (printer) {
                this.printer.printDocuments(10, "SlayerProfile.pdf");
            }
        }
    }

    static class YourThread extends Thread {
        Printer printer;

        YourThread(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            synchronized (printer) {
                this.printer.printDocuments(10, "DimmuProfile.pdf");
            }
        }
    }
}
