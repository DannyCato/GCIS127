package unit12.practicum;

public class EvensAndOdds {
    public static void main(String[] args) {
        Object key = new Object();

        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i += 2) {
                    synchronized(key) {
                        System.out.println(i);
                        key.notify();
                        try {
                            key.wait();
                        } catch (InterruptedException e) {}
                    }
                }
                
            }
        });
        odd.start();
        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i < 101; i += 2) {
                    synchronized(key) {
                        System.out.println(i);
                        key.notify();
                        if (i != 100) {
                            try {
                                key.wait();
                            } catch (InterruptedException e) {}
                        }
                    }
                }
                
            }
        });
        even.start();
    }
}
