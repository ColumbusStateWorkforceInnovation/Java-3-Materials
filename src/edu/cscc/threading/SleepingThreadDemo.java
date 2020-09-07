package edu.cscc.threading;

public class SleepingThreadDemo {
    public static void main(String[] args) {
        SleepingThread sleepingThread = new SleepingThread();
        sleepingThread.start();
        System.out.println("Starting another thread in the meantime...");
        CountingThread countingThread = new CountingThread();
        countingThread.start();
    }
}
