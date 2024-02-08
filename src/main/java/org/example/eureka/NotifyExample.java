package org.example.eureka;

public class NotifyExample {
    private String message;

    public synchronized String getMessage() {
        while (message == null) {
            try {
                wait(); // Wait until notified
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return message;
    }

    public synchronized void setMessage(String message) {
        this.message = message;
        notifyAll(); // Notify all waiting threads
    }
}
