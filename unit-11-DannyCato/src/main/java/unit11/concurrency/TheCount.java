package unit11.concurrency;

import java.util.Random;

public class TheCount implements Runnable {
    private static int[] COUNT = {0};
    private int id;

    public TheCount() {
        this.id = new Random().nextInt();
    }

    @Override
    public void run() {
            System.out.println(id);
            for (int i = 0; i < 100000; i++) {
                synchronized(COUNT) {
                    COUNT[0] = COUNT[0] + 1;
                }
            }
            System.out.println(id);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TheCount count = new TheCount();
            Thread t = new Thread(count);
            t.start();
            try {
                t.join(1); 
            } catch (InterruptedException e) {}
        }
        System.out.println("\t"+TheCount.COUNT[0]);
    }
 }
