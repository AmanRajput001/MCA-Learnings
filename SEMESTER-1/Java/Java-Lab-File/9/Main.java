/**
 * Familiarizing  the  concept  of  block, method and volatile
 * synchronization in Threads and File Handling.
 */

import java.io.FileWriter;
import java.io.IOException;

// SharedResource class represents a shared resource with a shared variable and a lock for synchronization.
class SharedResource {
    private int sharedVariable = 0;
    private Object lock = new Object();

    // Method to increment the shared variable, synchronized to ensure thread safety.
    public void increment() {
        synchronized (lock) {
            sharedVariable++;
        }
    }

    // Method to retrieve the shared variable value, synchronized to ensure thread safety.
    public int getSharedVariable() {
        synchronized (lock) {
            return sharedVariable;
        }
    }
}

// WorkerThread class represents a worker thread that increments the shared variable in the shared resource.
class WorkerThread extends Thread {
    private SharedResource sharedResource;

    // Constructor to initialize the WorkerThread with a shared resource.
    public WorkerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    // Run method simulates work by incrementing the shared variable and displaying its value.
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
            System.out.println(Thread.currentThread().getName() + " - Shared Variable: " + sharedResource.getSharedVariable());

            // Simulate some work
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class to demonstrate block and method synchronization, and file handling.
public class Main {
    public static void main(String[] args) {
        // Create an instance of SharedResource.
        SharedResource sharedResource = new SharedResource();

        // Create two WorkerThread instances with the same shared resource.
        WorkerThread thread1 = new WorkerThread(sharedResource);
        WorkerThread thread2 = new WorkerThread(sharedResource);

        // Start the threads.
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish.
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final shared variable value.
        System.out.println("Final Shared Variable Value: " + sharedResource.getSharedVariable());

        // File Handling - Write the shared variable value to a file ("output.txt").
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Final Shared Variable Value: " + sharedResource.getSharedVariable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
