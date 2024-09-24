package unit11.concurrency;

public class Deadlock implements Runnable{
    private Object k1;
    private Object k2;

    public Deadlock(Object k1, Object k2) {
        this.k1 = k1;
        this.k2 = k2;
    }

    @Override
    public void run() {
        synchronized(k1) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ie) {}
            
            synchronized(k2) {
                try { 
                    k1.wait();
                }
                catch (InterruptedException ie) {

                }
                System.out.println("Too slow for me!");
            }
        }

        
    }

    public static void main(String[] args) {
        Object k1 = new Object();
        Object k2 = new Object();
        for (int i = 0; i < 2; i++) {
            Deadlock dead = new Deadlock(k1, k2);
            dead.run();
        } 
    }
}
