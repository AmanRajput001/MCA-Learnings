// Runnable interface implementation
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread using Runnable interface - Count: " + i);
        }
    }
}

public class RunnableInterfaceExample {
    public static void main(String[] args) {
        // Creating a Runnable object
        MyRunnable myRunnable = new MyRunnable();

        // Creating and starting a thread using the Runnable interface
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        // Main thread's execution
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread - Count: " + i);
        }
    }
}
