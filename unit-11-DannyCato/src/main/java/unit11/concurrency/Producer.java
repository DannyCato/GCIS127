package unit11.concurrency;

import java.util.LinkedList;
import java.util.Random;

public class Producer extends Thread {
    private LinkedList<String> queue;
    private int id;
    
    public Producer(LinkedList<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(queue) {
                try {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ie) {}

                int num = new Random().nextInt(1, 5);
                for (int i = 0; i < num; i++) {
                    queue.add("" + i + "\t" + id);
                }
                queue.notifyAll();
            }
        }
        
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("man");
        list.add("what");
        list.add("massive brug");

        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(1, 10); i++) {
            Consumer con = new Consumer(list, rand.nextInt());
            con.start();
        }
        for (int i = 0; i < rand.nextInt(1, 10); i++) {
            Producer prod = new Producer(list, rand.nextInt());
            prod.start();
        }
        
    }
}
