// Thread class implementation
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread using Thread class - Count: " + i);
        }
    }
}

class ThreadClassExample {
    public static void main(String[] args) {
        // Creating and starting a thread using the Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        // Main thread's execution
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread - Count: " + i);
        }
    }
}
