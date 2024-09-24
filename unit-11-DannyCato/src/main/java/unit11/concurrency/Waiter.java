package unit11.concurrency;

public class Waiter implements Runnable{
    private static Object lock;

    public Waiter() {

    }

    @Override
    public void run() {
        synchronized(lock) {
            try {
                lock.wait();
                System.out.println("I'm done waiting!");
            }
            catch (InterruptedException ie) {
                System.out.println("something happened");
            }
        }
        
    }
    
    public static void main(String[] args) {
        Object lock = new Object();
        Waiter.lock = lock;
        for (int i = 0; i < 10; i++) {
            Waiter wait = new Waiter();
            Thread t = new Thread(wait);
            t.start();
        }
        for (int i = 0; i < 10000; i++) {} /*  What the fuck
        For some reason, the Waiter thread will not reach the lock.wait() in time for
        the lock.notify() to do anything. It's actually really annoying to be honest
        */
        synchronized(lock) { 
            lock.notifyAll();
            System.out.println("Notif");
        }
    }
}
