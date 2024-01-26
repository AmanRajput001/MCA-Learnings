//import java.lang.*;

//THREAD:- its is light weight processs, its is sub-proccess (small task) and 
//         Threads share common address space in a single process.

//------------------CREATING THE THREAD USING Thread class------------------
/*
    public class TryThread extends Thread{

        @Override
        public void run(){
            System.out.println("Thread1");
        }

        public static void main(String [] args){
            TryThread t = new TryThread();
            t.start();
        }
    } 
*/

//------------------CREATING THE THREAD USING Runnable interface------------------
/*
    public class TryThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread1");
        }

        public static void main(String[] args) {
            TryThread t = new TryThread();
            Thread th = new Thread(t);
            th.start();
        }
    }
*/

/*
    public class TryThread extends Thread {
    
        @Override
        public void run() {
            System.out.println("Thread1");
        }
    
        public void run(int a) { //will not run as thread when we  call start() 
                                 //it just call void run() overriden method only.
            System.out.println("Thread2");
        }
    
        public static void main(String[] args) {
            TryThread t = new TryThread();
            t.start();
        }
    }
*/

//------------------------MULTITHREDAING JAVA------------------------
/*
class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread1");
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Thread2");
    }
}

class MyThread3 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Thread3");
    }
}

class TryThread {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        MyThread3 t3 = new MyThread3();

        t1.start();
        t2.start();
        t3.start();
    }
}
*/

class MyThread1 extends Thread {
    public void run() {

        System.out.println(Thread.currentThread().getPriority());
        for (int i = 0; i < 10; i++) {
            // System.out.println("Thread1");
            System.out.println(Thread.currentThread().getName());

            if (i == 5) {
                try {
                    Thread.sleep(5000); // 5 second sleep
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

class MyThread2 extends Thread {
    public void run() {

        System.out.println(Thread.currentThread().getPriority());
        for (int i = 0; i < 10; i++)
            // System.out.println("Thread2");
            System.out.println(Thread.currentThread().getName());
    }
}

class MyThread3 extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Thread3");
    }
}

class TryThread {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        // t1.setPriority(6);
        MyThread2 t2 = new MyThread2();
        t2.setName("MISSON_2");
        // t2.setPriority(1);
        MyThread3 t3 = new MyThread3();

        t3.setPriority(10);

        t1.start();

        t2.start();

        if (true) {
            try {
                for (int i = 0; i < 10; i++) {
                    // System.out.println("Thread2");
                    System.out.println(Thread.currentThread().getName());
                    t1.join();
                }
                Thread.sleep(10000); // 5 second sleep
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        t3.start();
    }
}