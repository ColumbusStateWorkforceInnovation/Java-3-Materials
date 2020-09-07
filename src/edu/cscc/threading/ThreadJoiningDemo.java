package edu.cscc.threading;

public class ThreadJoiningDemo {
    public static void main(String[] args) {
        CountingThread firstThread = new CountingThread(0, 10);
        CountingThread secondThread = new CountingThread(0, 10);

        try {
            //Start each thread and wait for them to complete.
            //This is somewhat pointless as it defeats the purpose
            //of multi-threading.
            firstThread.start();
            firstThread.join();

            secondThread.start();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
