public class AnonymousThreadExample {
    public static void main(String[] args) {
        // Creating and starting a thread using anonymous implementation of Runnable
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread using Anonymous Implementation - Count: " + i);
                }
            }
        });
        myThread.start();

        // Main thread's execution
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread - Count: " + i);
        }
    }
}
